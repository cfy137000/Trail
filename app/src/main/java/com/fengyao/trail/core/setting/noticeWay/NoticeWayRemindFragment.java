package com.fengyao.trail.core.setting.noticeWay;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fengyao.trail.R;
import com.fengyao.trail.util.Utils;
import com.fengyao.trail.widget.CheckBoxPreference;

/**
 * Created by Chen fengYao on 2015/8/28.
 * 用于设置提醒方式的fragment
 */
public class NoticeWayRemindFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
    CheckBoxPreference remind_sound;
    CheckBoxPreference remind_shock;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_way_char, null);
        addPreferencesFromResource(R.xml.setting_notice_way_remind);
        remind_sound = (CheckBoxPreference) findPreference("switch_notice_way_remind_sound");
        remind_shock=(CheckBoxPreference) findPreference("switch_notice_way_remind_shock");
        remind_sound.setOnPreferenceChangeListener(this);
        remind_shock.setOnPreferenceChangeListener(this);
        return view;
    }



    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        switch (preference.getKey()){

            case "switch_notice_way_remind_shock"://当开启震动时震动一下
                if("true".equals(newValue.toString())){
                    Utils.shortShock();
                }
                break;
        }
        return true;
    }
}
