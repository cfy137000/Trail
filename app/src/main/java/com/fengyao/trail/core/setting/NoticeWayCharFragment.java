package com.fengyao.trail.core.setting;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fengyao.trail.R;

/**
 * Created by Chen fengYao on 2015/8/28.
 * 用于设置聊天方式的Fragment
 */
public class NoticeWayCharFragment extends PreferenceFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_way_char, null);
        addPreferencesFromResource(R.xml.setting_notice_way);
        return view;
    }
}
