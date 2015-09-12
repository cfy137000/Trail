package com.fengyao.trail.core.goal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;

/**
 * Created by Chen fengYao on 2015/9/9.
 * 人生目标
 */
public class GoalFragment extends BaseFragment implements View.OnClickListener, DialogClick {
    private View view;
    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private GoalAdapter goalAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_goal, null);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fb_goal);
        floatingActionButton.setOnClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_goal);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));//分割线
        goalAdapter = new GoalAdapter(getActivity());
        recyclerView.setAdapter(goalAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fb_goal) {
            DialogAddGoal dialogAddGoal = new DialogAddGoal(this);
            dialogAddGoal.show(getFragmentManager(), "目标");

        }
    }

    @Override
    public void onDialogPositiveClickListener() {
        goalAdapter.addData();
    }
}
