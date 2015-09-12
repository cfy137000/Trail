package com.fengyao.trail.core.Mission;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;
import com.fengyao.trail.core.chat.CharContactsFragment;
import com.fengyao.trail.core.chat.CharListFragment;
import com.fengyao.trail.core.chat.CharPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen fengYao on 2015/9/10.
 * 任务界面
 */
public class MissionFragment extends BaseFragment {
    private View view;
    private TabLayout missionTabLayout;
    private ViewPager viewPager;
    private List<BaseFragment> missionFragments;//放fragments
    private MissionPagerAdapter missionPagerAdapter;//用于加载页面的Adapte

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mission, null);
        missionTabLayout = (TabLayout) view.findViewById(R.id.tab_mission);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_mission);
        missionTabLayout.setTabTextColors(Color.WHITE, Color.GRAY);//设置文本在选中和为选中时候的颜色
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        missionFragments = new ArrayList<>();
        MissionListFragment missionListFragment = new MissionListFragment();
        MissionBoxFragment missionBoxFragment = new MissionBoxFragment();
        missionFragments.add(missionListFragment);
        missionFragments.add(missionBoxFragment);

        missionPagerAdapter = new MissionPagerAdapter(getActivity().getSupportFragmentManager(), missionFragments);

        viewPager.setAdapter(missionPagerAdapter);

        missionTabLayout.setupWithViewPager(viewPager);
    }
}
