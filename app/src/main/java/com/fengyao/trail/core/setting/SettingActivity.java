package com.fengyao.trail.core.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseActivity;
import com.fengyao.trail.core.setting.noticeWay.NoticeWayActivity;
import com.fengyao.trail.core.setting.personalCenter.PersonalCenterActivity;

/**
 * Created by Chen fengYao on 2015/8/27.
 * 设置页面
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar settingToolBar;
    private TextView personalCenterTv,tomatoTv,noticeWayTv,noticeTimeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();

    }

    /**
     * 初始化各个组件
     */
    private void init() {
        //toolBar
        settingToolBar = (Toolbar) findViewById(R.id.toolbar_setting);
        settingToolBar.setTitle(getResources().getString(R.string.setting));
        settingToolBar.setBackgroundColor(values.getToolBarColor());
        settingToolBar.setNavigationIcon(R.mipmap.ic_back);
        //toolBar的返回事件
        setSupportActionBar(settingToolBar);
        settingToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //四个tv
        personalCenterTv = (TextView) findViewById(R.id.tv_setting_personal_center);
        tomatoTv = (TextView) findViewById(R.id.tv_setting_tomato);
        noticeWayTv = (TextView) findViewById(R.id.tv_setting_notice_way);
        noticeTimeTv = (TextView) findViewById(R.id.tv_setting_notice_time);
        //绑定点击事件
        personalCenterTv.setOnClickListener(this);
        tomatoTv.setOnClickListener(this);
        noticeWayTv.setOnClickListener(this);
        noticeTimeTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.tv_setting_personal_center:
                intent.setClass(this, PersonalCenterActivity.class);
                break;
            case R.id.tv_setting_tomato:
                break;
            case R.id.tv_setting_notice_way://跳转到通知方式
                intent.setClass(this,NoticeWayActivity.class);
                break;
            case R.id.tv_setting_notice_time:
                break;
        }
        startActivity(intent);
    }
}
