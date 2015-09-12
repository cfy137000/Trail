package com.fengyao.trail.core.setting.noticeTime;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseActivity;
import com.fengyao.trail.data.SQLTool;
import com.fengyao.trail.data.tables.SettingNoticeTimeTable;
import com.gc.materialdesign.views.Slider;

/**
 * Created by Chen fengYao on 2015/8/30.
 * 用于设置通知的默认时间
 */
public class NoticeTimeActivity extends BaseActivity {
    private Toolbar noticeTimeToolBar;
    private TextView remindTv, missionBeforeTv, missionAfterTv;
    private TextView remindDefaultTv, missionBeforeDefaultTv, missionAfterDefaultTv;
    private Slider remindSlider, missionBeforeSlider, missionAfterSlider;
    private SettingNoticeTimeTable settingNoticeTimeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_time);
        init();
    }

    private void init() {
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

        //初始化TextView
        remindTv = (TextView) findViewById(R.id.tv_remind_time);
        missionBeforeTv = (TextView) findViewById(R.id.tv_mission_before_time);
        missionAfterTv = (TextView) findViewById(R.id.tv_mission_after_time);
        remindDefaultTv = (TextView) findViewById(R.id.tv_remind_time_default);
        missionBeforeDefaultTv = (TextView) findViewById(R.id.tv_mission_before_time_default);
        missionAfterDefaultTv = (TextView) findViewById(R.id.tv_mission_after_time_deault);


        remindSlider = (Slider) findViewById(R.id.slider_remind);
        missionBeforeSlider = (Slider) findViewById(R.id.slider_missiom_before);
        missionAfterSlider = (Slider) findViewById(R.id.slider_missiom_after);

        remindSlider.setValue(10);
        missionBeforeSlider.setValue(10);
        missionAfterSlider.setValue(10);

        remindSlider.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                mSetText(remindDefaultTv, value);
            }
        });
        missionBeforeSlider.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                mSetText(missionBeforeDefaultTv, value);
            }
        });
        missionAfterSlider.setOnValueChangedListener(new Slider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                mSetText(missionAfterDefaultTv, value);
            }
        });

        //初始化数据库
        settingNoticeTimeTable = (SettingNoticeTimeTable) sqlTool.tableFactory(SQLTool.TableName.settingNoticeTime);
        //通过数据库的数据初始化
        remindSlider.setValue(settingNoticeTimeTable.getSettingNoticeTimeRemind());
        missionBeforeSlider.setValue(settingNoticeTimeTable.getSettingNoticeTimeMissionBefor());
        missionAfterSlider.setValue(settingNoticeTimeTable.getSettingNoticeTimeAfter());
        mSetText(remindDefaultTv, settingNoticeTimeTable.getSettingNoticeTimeRemind());
        mSetText(missionBeforeDefaultTv, settingNoticeTimeTable.getSettingNoticeTimeMissionBefor());
        mSetText(missionAfterDefaultTv, settingNoticeTimeTable.getSettingNoticeTimeAfter());
    }

    @Override
    protected void onPause() {
        super.onPause();
        settingNoticeTimeTable.setRemind(remindSlider.getValue());
        settingNoticeTimeTable.setMissionBefor(missionBeforeSlider.getValue());
        settingNoticeTimeTable.setMissionAfter(missionAfterSlider.getValue());
    }

    private void mSetText(TextView textView, int value) {
        switch (value) {
            case 0:
                textView.setText("任务结束时提醒");
                break;
            default:
                textView.setText("任务结束前" + value + "分钟提醒");
                break;
        }
    }
}
