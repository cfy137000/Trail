package com.fengyao.trail.core.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.easemob.EMError;
import com.easemob.chat.EMChatManager;
import com.easemob.exceptions.EaseMobException;
import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;
import com.fengyao.trail.util.MLogger;
import com.fengyao.trail.util.MyToast;

/**
 * Created by Chen fengYao on 2015/9/5.
 * 注册页面
 */
public class RegisterFragment extends BaseFragment implements View.OnClickListener {
    private EditText userName, psw;//用户名和密码
    private Button registerBtn;//登录按钮
    private View view;

    private String usernameIn, pswIn;
    private LoginAndRegisterActivity loginAndRegisterActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, null);
        initWidget();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loginAndRegisterActivity = (LoginAndRegisterActivity) getActivity();
    }

    private void initWidget() {
        userName = (EditText) view.findViewById(R.id.et_register_username);
        psw = (EditText) view.findViewById(R.id.et_register_password);
        registerBtn = (Button) view.findViewById(R.id.btn_register_register);
        registerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register_register) {

            usernameIn = userName.getText().toString();
            pswIn = psw.getText().toString();

            loginAndRegisterActivity.register(usernameIn, pswIn);//注册

        }
    }
}
