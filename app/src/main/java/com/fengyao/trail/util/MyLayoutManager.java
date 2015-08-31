package com.fengyao.trail.util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by Chen fengYao on 2015/8/31.
 * 自定义的LinearLayoutManager
 * 用于设置RecyclerView的大小,使RecyclerView大小适应Item
 */
public class MyLayoutManager extends LinearLayoutManager {
    public View view;
    public int count;
    public MyLayoutManager(Context context) {
        super(context);
    }

    public MyLayoutManager(View view,Context context,int count){
       this(context);
        this.view = view;
        this.count = count;
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec,int heightSpec) {

        if(view != null){

            int measuredWidth = view.getWidth();
            int measuredHeight = view.getHeight()*count;
            Log.i("sysout","measuredHeight:"+measuredHeight+"");
            setMeasuredDimension(measuredWidth, measuredHeight);
        }


    }

}
