package com.fengyao.trail.core.setting.noticeTime;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseActivity;

/**
 * Created by Chen fengYao on 2015/8/30.
 * 用于设置通知的默认时间
 */
public class NoticeTimeActivity extends BaseActivity implements ChangeFragmentInterface {
    private Toolbar noticeTimeToolBar;
    private FrameLayout noticeTimeFl;
    private FragmentManager fragmentManager;
    private NoticeTimeDefaultFragment noticeTimeDefaultFragment;
    private SettingNoticeTimeBeforeFragment settingNoticeTimeBeforeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_time);
        init();
    }

    private void init(){
        noticeTimeToolBar = (Toolbar) findViewById(R.id.toolbar_setting_notice_time);
        noticeTimeToolBar.setTitle(getResources().getString(R.string.setting_notice_time_title));
        noticeTimeToolBar.setBackgroundColor(values.getToolBarColor());
        noticeTimeToolBar.setNavigationIcon(R.mipmap.ic_back);
        //toolBar的返回事件
        setSupportActionBar(noticeTimeToolBar);
        noticeTimeToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        noticeTimeFl = (FrameLayout) findViewById(R.id.fl_setting_notice_time);


        noticeTimeDefaultFragment = new NoticeTimeDefaultFragment(this);
        settingNoticeTimeBeforeFragment = new SettingNoticeTimeBeforeFragment();
        transaction.replace(R.id.fl_setting_notice_time, noticeTimeDefaultFragment);
        transaction.commit();

    }


    @Override
    public void changeToSettingBefore() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_setting_notice_time, settingNoticeTimeBeforeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
