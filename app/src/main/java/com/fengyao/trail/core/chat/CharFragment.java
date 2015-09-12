package com.fengyao.trail.core.chat;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen fengYao on 2015/9/4.
 * 聊天界面
 */
public class CharFragment extends BaseFragment {
    private TabLayout charTabLayout;
    private ViewPager viewPager;
    private List<BaseFragment> charFragments;//放fragments
    private CharPagerAdapter charPagerAdapter;//用于加载页面的Adapte

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_char, null);
        charTabLayout = (TabLayout) view.findViewById(R.id.tab_char);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_char);
        charTabLayout.setTabTextColors(Color.WHITE, Color.GRAY);//设置文本在选中和为选中时候的颜色

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        charFragments = new ArrayList<>();
        CharListFragment charListFragment = new CharListFragment();
        CharContactsFragment charContactsFragment = new CharContactsFragment();
        charFragments.add(charListFragment);
        charFragments.add(charContactsFragment);

        charPagerAdapter = new CharPagerAdapter(getActivity().getSupportFragmentManager(), charFragments);

        viewPager.setAdapter(charPagerAdapter);

        charTabLayout.setupWithViewPager(viewPager);
    }
}
