package com.fengyao.trail.core.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;
import com.fengyao.trail.core.setting.noticeTime.NoticeTimeActivity;
import com.fengyao.trail.core.setting.noticeWay.NoticeWayActivity;
import com.fengyao.trail.core.setting.personalCenter.PersonalCenterActivity;
import com.fengyao.trail.core.setting.tomato.TomatoSettingActivity;

/**
 * Created by Chen fengYao on 2015/8/27.
 * 设置页面
 */
public class SettingFragment extends BaseFragment implements View.OnClickListener {

    private TextView personalCenterTv, tomatoTv, noticeWayTv, noticeTimeTv;
    private View view;
    private ImageView settingBackgroundIv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setting, null);
        init();
        return view;
    }

    /**
     * 初始化各个组件
     */
    private void init() {
        //背景图片
//        settingBackgroundIv = (ImageView) view.findViewById(R.id.iv_setting_background);

        //四个tv
        personalCenterTv = (TextView) view.findViewById(R.id.tv_setting_personal_center);
        tomatoTv = (TextView) view.findViewById(R.id.tv_setting_tomato);
        noticeWayTv = (TextView) view.findViewById(R.id.tv_setting_notice_way);
        noticeTimeTv = (TextView) view.findViewById(R.id.tv_setting_notice_time);
        //绑定点击事件
        personalCenterTv.setOnClickListener(this);
        tomatoTv.setOnClickListener(this);
        noticeWayTv.setOnClickListener(this);
        noticeTimeTv.setOnClickListener(this);
    }

    //点击事件,跳转到四个子设置页面
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.tv_setting_personal_center:
                intent.setClass(getActivity(), PersonalCenterActivity.class);
                break;
            case R.id.tv_setting_tomato:
                intent.setClass(getActivity(), TomatoSettingActivity.class);
                break;
            case R.id.tv_setting_notice_way://跳转到通知方式
                intent.setClass(getActivity(), NoticeWayActivity.class);
                break;
            case R.id.tv_setting_notice_time:
                intent.setClass(getActivity(), NoticeTimeActivity.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //startBackgroundAnim();
    }

//    private void startBackgroundAnim() {
//        Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.setting_background);
//        settingBackgroundIv.startAnimation(animation);
//    }
}
