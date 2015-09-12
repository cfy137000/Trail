package com.fengyao.trail.core.Mission;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chen fengYao on 2015/9/10.
 * 显示任务列表的Adapter
 */
public class MissionListAdapter extends RecyclerView.Adapter<MissionListAdapter.MyViewHolder> {
    @Override
    public MissionListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MissionListAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
