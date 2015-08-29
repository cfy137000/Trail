package com.fengyao.trail.core.setting;

import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseActivity;
import com.fengyao.trail.util.Values;

/**
 * Created by Chen fengYao on 2015/8/28.
 * 通知方式的设置页面
 */
public class NoticeWayActivity extends BaseActivity {
    private Toolbar noticeWayToolBar;

    private Values values = Values.getValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_way);

        init();
    }

    private void init(){
        //toolBar
        noticeWayToolBar = (Toolbar) findViewById(R.id.toolbar_notice_way);
        noticeWayToolBar.setTitle(getResources().getString(R.string.notice_way));
        noticeWayToolBar.setBackgroundColor(values.getToolBarColor());
        noticeWayToolBar.setNavigationIcon(R.mipmap.ic_back);
        //toolBar的返回事件
        noticeWayToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }


}
