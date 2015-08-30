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
 * 用于设置聊天方式的Fragment
 */
public class NoticeWayCharFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
    CheckBoxPreference charReceive,charSound,charShock;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice_way_char, null);
        addPreferencesFromResource(R.xml.setting_notice_way);

        charReceive = (CheckBoxPreference) findPreference("switch_notice_way_char_receive");
        charSound= (CheckBoxPreference) findPreference("switch_notice_way_char_sound");
        charShock= (CheckBoxPreference) findPreference("switch_notice_way_char_shock");

        charReceive.setOnPreferenceChangeListener(this);
        charSound.setOnPreferenceChangeListener(this);
        charShock.setOnPreferenceChangeListener(this);
        return view;
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        switch (preference.getKey()){
            case "switch_notice_way_char_shock":
                if("true".equals(newValue.toString())){
                    Utils.shortShock();
                }
                break;
        }

        return true;
    }
}
