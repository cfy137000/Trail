package com.fengyao.trail.core.Mission;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseApplication;
import com.fengyao.trail.base.BaseFragment;

import java.util.List;

/**
 * Created by Chen fengYao on 2015/9/10.
 */
public class MissionPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;
    private String[] title;

    public MissionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MissionPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        this(fm);
        this.fragments = fragments;
        title = BaseApplication.getContext().getResources().getStringArray(R.array.mission_page_title);
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments != null && fragments.size() > 0) {
            return fragments.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (fragments != null) {
            return fragments.size();
        }
        return 0;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
