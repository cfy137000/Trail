package com.fengyao.trail.core.goal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

import com.fengyao.trail.R;
import com.fengyao.trail.data.SQLTool;
import com.fengyao.trail.data.tables.GoalTable;

/**
 * Created by Chen fengYao on 2015/9/9.
 * 人生目标的对话框
 */
public class DialogAddGoal extends DialogFragment {

    private View view;
    private EditText age, goalContext;
    private GoalTable goalTable;
    private DialogClick dialogClick;
    private GoalFragment goalFragment;

    public DialogAddGoal() {
        super();
    }

    @SuppressLint("ValidFragment")
    public DialogAddGoal(GoalFragment fragment) {
        this();
        goalFragment = fragment;
    }

    public void init() {
        age = (EditText) view.findViewById(R.id.et_dialog_add_goal_age);
        goalContext = (EditText) view.findViewById(R.id.et_dialog_add_goal_hint);
        goalTable = (GoalTable) SQLTool.getInstance().tableFactory(SQLTool.TableName.goal);

        dialogClick = goalFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.dialog_add_goal, null);
        init();
        builder.setView(view)

                .setPositiveButton("确认",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                goalTable.insert(Integer.valueOf(age.getText().toString()),
                                        goalContext.getText().toString());
                                goalFragment.onDialogPositiveClickListener();
                            }
                        }).setNegativeButton("取消", null);
        return builder.create();
    }
}
