package com.fengyao.trail.core.setting.noticeTime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fengyao.trail.R;

/**
 * Created by Chen fengYao on 2015/8/31.
 */
public class SettingNoticeTimeBeforeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_notice_time_before,null);
        return view;
    }
}
