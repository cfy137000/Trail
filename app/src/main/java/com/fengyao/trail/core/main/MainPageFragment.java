package com.fengyao.trail.core.main;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;
import com.fengyao.trail.util.DisplayUtil;
import com.fengyao.trail.util.blur.FastBlur;
import com.fengyao.trail.widget.MyScrollView;
import com.fengyao.trail.widget.MyScrollViewListener;
import com.gc.materialdesign.utils.Utils;

/**
 * Created by Chen fengYao on 2015/9/1.
 * 主页内容
 */
public class MainPageFragment extends BaseFragment implements MyScrollViewListener {
    public View view;
    public TextView topBlank;
    public RelativeLayout mainContentBottom;
    private ImageView background;
    private DisplayMetrics dm;
    private MyScrollView mainScrollView;
    int toolBarHeight;
    private MainPageActivity mainPageActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_page, null);
        topBlank = (TextView) view.findViewById(R.id.main_top_blank);
        mainContentBottom = (RelativeLayout) view.findViewById(R.id.main_content_bottom);
        background = (ImageView) view.findViewById(R.id.iv_main_background);
        mainScrollView = (MyScrollView) view.findViewById(R.id.main_scroll);
        mainScrollView.setScrollViewListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        topBlank.setHeight((int) ((dm.heightPixels) / 2.6f));
        mainContentBottom.setMinimumHeight((int) (dm.heightPixels - ((dm.heightPixels) / 2.6f)));
        applyBlur();
        mainPageActivity = (MainPageActivity) getActivity();
        toolBarHeight = mainPageActivity.getToolbarHeight();
//TODO 颜色的改变算法需要调整
        //  colorChange();

    }

    private void applyBlur() {
        background.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                background.getViewTreeObserver().removeOnPreDrawListener(this);
                background.buildDrawingCache();

                Bitmap bmp = background.getDrawingCache();
                blur(bmp, mainContentBottom);
                return true;
            }
        });
    }

    @SuppressLint("NewApi")
    private void blur(Bitmap bkg, View view) {

        float scaleFactor = 10;
        float radius = 4;
        int[] location = new int[2];
        view.getLocationInWindow(location);

        Bitmap overlay = Bitmap.createBitmap((int) (view.getMeasuredWidth() / scaleFactor),
                (int) (view.getMeasuredHeight() / scaleFactor), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);
        canvas.translate(-view.getLeft() / scaleFactor, -(location[1] - (mainPageActivity.getToolbarHeight() + mainPageActivity.getStatusBarHeight())) / scaleFactor);

        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(bkg, 0, 0, paint);

        overlay = FastBlur.doBlur(overlay, (int) radius, true);
        view.setBackground(new BitmapDrawable(getResources(), overlay));

    }

    //滚动监听
    @Override
    public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
        applyBlur();//滚动时产生毛玻璃效果
    }

    /**
     * 界面颜色的更改
     */
    @SuppressLint("NewApi")
    private void colorChange() {
        // 用来提取颜色的Bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_main_background_default);
        // Palette的部分
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            /**
             * 提取完之后的回调方法
             */
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                Toolbar mToolbar = mainPageActivity.getmToolbar();
                mToolbar.setBackgroundColor(vibrant.getRgb());
                LinearLayout head = mainPageActivity.getHeader();
                head.setBackgroundColor(colorBurn(vibrant.getRgb()));
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    Window window = mainPageActivity.getWindow();
                    // 很明显，这两货是新API才有的。
                    window.setStatusBarColor(colorBurn(vibrant.getRgb()));
                    window.setNavigationBarColor(colorBurn(vibrant.getRgb()));
                }
            }
        });
    }

    /**
     * 颜色加深处理
     *
     * @param RGBValues RGB的值，由alpha（透明度）、red（红）、green（绿）、blue（蓝）构成，
     *                  Android中我们一般使用它的16进制，
     *                  例如："#FFAABBCC",最左边到最右每两个字母就是代表alpha（透明度）、
     *                  red（红）、green（绿）、blue（蓝）。每种颜色值占一个字节(8位)，值域0~255
     *                  所以下面使用移位的方法可以得到每种颜色的值，然后每种颜色值减小一下，在合成RGB颜色，颜色就会看起来深一些了
     * @return
     */
    private int colorBurn(int RGBValues) {
        int alpha = RGBValues >> 24;
        int red = RGBValues >> 16 & 0xFF;
        int green = RGBValues >> 8 & 0xFF;
        int blue = RGBValues & 0xFF;
        red = (int) Math.floor(red * (1 - 0.1));
        green = (int) Math.floor(green * (1 - 0.1));
        blue = (int) Math.floor(blue * (1 - 0.1));
        return Color.rgb(red, green, blue);
    }


}
