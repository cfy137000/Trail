package com.fengyao.trail.core.setting.noticeTime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.util.MyLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen fengYao on 2015/8/31.
 * 默认提醒时间的Fragment
 */
@SuppressLint("ValidFragment")
public class NoticeTimeDefaultFragment extends Fragment implements View.OnClickListener {
    private RecyclerView remindTimeRv,missionTimeBeforeRv,missionTimeAfterRv;
    private List<String> remindData,missionBeforeData,missionAfterData;
    private View view;
    private Context context;
    private TextView missionBeforeTv,missionAfterTv;

    TextView noticeTimeRemindDefault;
    private ChangeFragmentInterface changeFragmentInterface;

    @SuppressLint("ValidFragment")
    public NoticeTimeDefaultFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        changeFragmentInterface = (ChangeFragmentInterface) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notice_time_default,null);
        remindTimeRv = (RecyclerView) view.findViewById(R.id.rv_notice_time_remind);
        remindTimeRv.setItemAnimator(new DefaultItemAnimator());
        remindData = new ArrayList<>();
        remindData.add("提前5分钟");

        remindTimeRv.setAdapter(new TimeDefaultAdapter());

        noticeTimeRemindDefault = (TextView) view.findViewById(R.id.tv_notice_time_default);

        remindTimeRv.setLayoutManager(new MyLayoutManager(noticeTimeRemindDefault, context, remindData.size()));

        noticeTimeRemindDefault.setOnClickListener(this);


        //*****任务****//
        missionTimeBeforeRv = (RecyclerView) view.findViewById(R.id.rv_notice_time_mission_before);
        missionTimeBeforeRv.setItemAnimator(new DefaultItemAnimator());
        missionBeforeData = new ArrayList<>();
        missionBeforeData.add("提前5分钟");
        missionTimeBeforeRv.setAdapter(new TimeDefaultAdapter());
        missionBeforeTv = (TextView) view.findViewById(R.id.tv_mission_before_time);
        missionTimeBeforeRv.setLayoutManager(new MyLayoutManager(missionBeforeTv,context,missionBeforeData.size()));
        missionBeforeTv.setOnClickListener(this);

        /******任务三*******/
        missionTimeAfterRv = (RecyclerView) view.findViewById(R.id.rv_notice_time_mission_after);
        missionTimeAfterRv.setItemAnimator(new DefaultItemAnimator());
        missionAfterData = new ArrayList<>();
        missionAfterData.add("提前5分钟");
        missionTimeAfterRv.setAdapter(new TimeDefaultAdapter());
        missionAfterTv = (TextView) view.findViewById(R.id.tv_mission_after_time);
        missionTimeAfterRv.setLayoutManager(new MyLayoutManager(missionAfterTv,context,missionBeforeData.size()));
        missionAfterTv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_notice_time_default:
                changeFragmentInterface.changeToSettingBefore();
                break;
        }
    }

    public class TimeDefaultAdapter extends RecyclerView.Adapter<TimeDefaultAdapter.MyViewHolder>{

        @Override
        public TimeDefaultAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fragment_notice_time,
                    null));
            return holder;
        }

        @Override
        public void onBindViewHolder(TimeDefaultAdapter.MyViewHolder holder, int position) {
            holder.tv.setText(remindData.get(position));//设置数据

        }

        @Override
        public int getItemCount() {
            return remindData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView tv;

            public MyViewHolder(View view)
            {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv_item_notice_time);

            }
        }
    }



}
