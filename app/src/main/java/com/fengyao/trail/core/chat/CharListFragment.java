package com.fengyao.trail.core.chat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.easemob.chat.EMContactManager;
import com.easemob.exceptions.EaseMobException;
import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;
import com.fengyao.trail.util.MyToast;

/**
 * Created by Chen fengYao on 2015/9/4.
 */
public class CharListFragment extends BaseFragment implements View.OnClickListener {
    private TextView addFriendsTv, noticeTv, groupCharTv;
    private View view;
    private View addFriendNameDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_char_list, null);
        initWeight();
        return view;
    }

    private void initWeight() {
        addFriendsTv = (TextView) view.findViewById(R.id.tv_char_list_add_friends);
        noticeTv = (TextView) view.findViewById(R.id.tv_char_list_notice);
        groupCharTv = (TextView) view.findViewById(R.id.tv_char_list_group_char);

        addFriendsTv.setOnClickListener(this);
        noticeTv.setOnClickListener(this);
        groupCharTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_char_list_add_friends://添加好友
                showBuilder();
                break;
            case R.id.tv_char_list_notice:
                break;
            case R.id.tv_char_list_group_char:
                break;
        }
    }

    private void showBuilder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setPositiveButton("添加", new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText friendName = (EditText) addFriendNameDialog.findViewById(R.id.et_dialog_friends_name);
                String friendNameIn = friendName.getText().toString();

                try {
                    EMContactManager.getInstance().addContact(friendNameIn, " ");//需异步处理
                    Log.i("Sysout", friendNameIn);
                } catch (EaseMobException e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("返回", new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        addFriendNameDialog = getActivity().getLayoutInflater().inflate(R.layout.dialog_add_friends, null);
        builder.setView(addFriendNameDialog);
        builder.show();

    }
}
