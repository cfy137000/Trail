package com.fengyao.trail.core.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;
import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseFragment;
import com.fengyao.trail.core.main.MainPageActivity;

/**
 * Created by Chen fengYao on 2015/9/5.
 * 登陆的Fragment
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private EditText userName, psw;//用户名和密码
    private Button loginBtn;//登录按钮
    private TextView forgot, register;//注册和忘记密码
    private View view;
    private LoginAndRegisterActivity loginAndRegisterActivity;
    private String userNameIn, passwordIn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, null);
        initWidget();
        return view;
    }

    //初始化组件
    private void initWidget() {
        userName = (EditText) view.findViewById(R.id.et_login_username);
        psw = (EditText) view.findViewById(R.id.et_login_password);
        loginBtn = (Button) view.findViewById(R.id.btn_login_login);
        forgot = (TextView) view.findViewById(R.id.tv_login_forgot);
        register = (TextView) view.findViewById(R.id.tv_login_register);

        loginBtn.setOnClickListener(this);
        forgot.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loginAndRegisterActivity = (LoginAndRegisterActivity) getActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_login://登陆按钮
                userNameIn = userName.getText().toString();
                passwordIn = psw.getText().toString();
                loginAndRegisterActivity.login(userNameIn, passwordIn);//登陆
                break;
            case R.id.tv_login_forgot://忘记密码
                break;
            case R.id.tv_login_register://注册
                loginAndRegisterActivity.switchToRegister();
                break;
        }
    }


}
