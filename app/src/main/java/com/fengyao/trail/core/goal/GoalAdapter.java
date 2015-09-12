package com.fengyao.trail.core.goal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.data.SQLTool;
import com.fengyao.trail.data.beans.GoalData;
import com.fengyao.trail.data.tables.GoalTable;

import java.util.List;

/**
 * Created by Chen fengYao on 2015/9/9.
 * 用于向RecycleView里添加数据的
 */
public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.MyViewHolder> {
    private Context context;
    private List<GoalData> goalDatas;
    private GoalTable goalTable;

    public GoalAdapter(Context context) {
        this.context = context;
        goalTable = (GoalTable) SQLTool.getInstance().tableFactory(SQLTool.TableName.goal);
        goalDatas = goalTable.getGoals();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_goal_fragment, parent,
                false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.goalContextTv.setText("我要在 " + goalDatas.get(position).getAge() +
                " 岁 " + goalDatas.get(position).getGoalContext());
        if (goalDatas.get(position).getFinishTime().equals("-1")) {
            holder.isDone.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if (goalDatas == null) {
            return 0;
        }
        return goalDatas.size();
    }

    //item的布局
    class MyViewHolder extends ViewHolder {
        TextView goalContextTv;
        Button isDone;

        public MyViewHolder(View itemView) {
            super(itemView);
            goalContextTv = (TextView) itemView.findViewById(R.id.tv_goal_context);
            isDone = (Button) itemView.findViewById(R.id.goal_is_done);
        }
    }

    public void addData() {
        goalDatas = goalTable.getGoals();
        notifyDataSetChanged();
    }
}
