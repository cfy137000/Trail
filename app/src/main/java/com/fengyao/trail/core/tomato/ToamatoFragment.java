package com.fengyao.trail.core.tomato;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;
import com.fengyao.trail.data.SQLTool;
import com.fengyao.trail.data.beans.TomatoData;
import com.fengyao.trail.data.tables.SettingTomatoTable;
import com.fengyao.trail.data.tables.StatisticTomatoTable;
import com.fengyao.trail.service.TomatoServiceManager;
import com.fengyao.trail.widget.CircleTimerView;
import com.gc.materialdesign.views.ButtonRectangle;

/**
 * Created by Chen fengYao on 2015/9/3.
 * 番茄时钟页面
 */
public class ToamatoFragment extends BaseFragment implements View.OnClickListener {
    private ButtonRectangle startTomato, stopTomato;
    private CircleTimerView tomatoClock;
    private SettingTomatoTable settingTomatoTable;
    private StatisticTomatoTable statisticTomatoTable;

    //TODO 有待完成
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tomato, null);
        startTomato = (ButtonRectangle) view.findViewById(R.id.btn_tomato_clock);
        stopTomato = (ButtonRectangle) view.findViewById(R.id.btn_tomato_clock_stop);

        //两张表
        settingTomatoTable = (SettingTomatoTable) sqlTool.tableFactory(SQLTool.TableName.settingTomato);
        statisticTomatoTable = (StatisticTomatoTable) sqlTool.tableFactory(SQLTool.TableName.statisticTomato);

        startTomato.setOnClickListener(this);
        stopTomato.setOnClickListener(this);
        tomatoClock = (CircleTimerView) view.findViewById(R.id.ctv_tomato_clock);
        tomatoClock.setMaxTime(settingTomatoTable.qureSettingTomato().get(1));
        tomatoClock.setClockStart();

        //与服务绑定
        TomatoServiceManager.getInstance().startService(getActivity());
        TomatoServiceManager.getInstance().bindService(getActivity());//绑定


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tomato_clock:
                tomatoClock.startTimer();
                TomatoServiceManager.getInstance().startTomatoWork();
                break;
            case R.id.btn_tomato_clock_stop:
                TomatoServiceManager.getInstance().stopTomatoWork();
                tomatoClock.pauseTimer();
                tomatoClock.setMaxTime(settingTomatoTable.qureSettingTomato().get(1));//还原番茄时钟
                break;
        }

    }
}
