package com.fengyao.trail.core.Mission;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;

/**
 * Created by Chen fengYao on 2015/9/10.
 * 任务的列表
 */
public class MissionListFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mission_list, null);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fb_mission_list);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_mission_list);

        recyclerView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fb_mission_list:
                break;
        }
    }
}
