package com.fengyao.trail.core.Mission;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.fengyao.trail.R;
import com.fengyao.trail.data.SQLTool;
import com.fengyao.trail.data.beans.MissionData;
import com.fengyao.trail.data.tables.GoalTable;

/**
 * Created by Chen fengYao on 2015/9/10.
 * 添加任务的弹出框
 */
public class addMissionDialog extends DialogFragment {
    private View view;
    private EditText missionContextEt;
    private TextView startTimeTv, endTimeTv;
    private MissionData missionData;

    public void init() {
        missionContextEt = (EditText) view.findViewById(R.id.et_dialog_add_mission_context);
        startTimeTv = (TextView) view.findViewById(R.id.tv_dialog_add_mission_start_time);
        endTimeTv = (TextView) view.findViewById(R.id.tv_dialog_add_mission_end_time);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.dialog_add_mission, null);
        init();
        builder.setView(view)

                .setPositiveButton("确认",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        }).setNegativeButton("取消", null);
        return builder.create();
    }

}
