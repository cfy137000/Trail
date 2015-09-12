package com.fengyao.trail.core.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.easemob.EMCallBack;
import com.easemob.EMError;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;
import com.easemob.exceptions.EaseMobException;
import com.fengyao.trail.R;
import com.fengyao.trail.base.BaseActivity;
import com.fengyao.trail.core.main.MainPageActivity;
import com.fengyao.trail.data.SQLTool;
import com.fengyao.trail.data.tables.SettingUserTable;
import com.fengyao.trail.util.MLogger;

/**
 * Created by Chen fengYao on 2015/9/5.
 * 登陆页面
 */
public class LoginAndRegisterActivity extends BaseActivity implements Handler.Callback {
    private ImageView backgroundIv;//背景图片
    private Handler mHandler;
    public MLogger mLogger;
    private SettingUserTable settingUserTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingUserTable = (SettingUserTable) sqlTool.tableFactory(SQLTool.TableName.settingUser);

        // 如果用户名密码都有，直接进入主页面
        if (EMChat.getInstance().isLoggedIn()) {

            MainPageActivity.startMainPageActivity(this, settingUserTable.qureUser().get(0));
            finish();
            return;
        }

        setContentView(R.layout.activity_login_and_register);
        mLogger = new MLogger(LoginAndRegisterActivity.class);
        initWidget();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(LoginAndRegisterActivity.this, R.anim.translate_anim);
                backgroundIv.startAnimation(animation);
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_login_register, new LoginFragment()).commit();
    }

    //初始化组件
    private void initWidget() {
        backgroundIv = (ImageView) findViewById(R.id.img_backgroud_login);
        mHandler = new Handler(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }

    //跳转到设置界面
    public void switchToRegister() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_login_register,
                new RegisterFragment()).addToBackStack(null).commit();

    }


    public void toastHint(String msg) {
        Snackbar.make(backgroundIv, msg, Snackbar.LENGTH_SHORT).show();
    }

    //登陆方法
    public void login(final String userNameIn, String passwordIn) {
        EMChatManager.getInstance().login(userNameIn, passwordIn, new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        EMGroupManager.getInstance().loadAllGroups();
                        EMChatManager.getInstance().loadAllConversations();
                        Log.d("main", "登陆聊天服务器成功！");
                        //TODO 拉取个人信息
                        settingUserTable.insert(userNameIn, "1970-1-1", "男");//插入默认的用户信息
                        MainPageActivity.startMainPageActivity(LoginAndRegisterActivity.this,
                                settingUserTable.qureUser().get(0));
                    }
                });
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.d("main", "登陆聊天服务器失败！");
            }
        });
    }

    //注册方法
    public void register(final String userNameIn, final String pswIn) {
        mLogger.info("--->注册开始");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 调用sdk注册方法
                    EMChatManager.getInstance().createAccountOnServer(userNameIn, pswIn);
                    toastHint("注册成功");

                    login(userNameIn, pswIn);//注册成功就直接登录

                } catch (final EaseMobException e) {
                    int errorCode = e.getErrorCode();
                    if (errorCode == EMError.NONETWORK_ERROR) {
                        mLogger.info("网络异常，请检查网络！");
                        toastHint("网络异常，请检查网络！");
                    } else if (errorCode == EMError.USER_ALREADY_EXISTS) {
                        mLogger.info("用户已存在！");
                        toastHint("用户已存在！");
                    } else if (errorCode == EMError.UNAUTHORIZED) {
                        mLogger.info("注册失败，无权限！");
                        toastHint("注册失败，无权限！");
                    } else {
                        mLogger.info("注册失败: " + e.getMessage());
                        toastHint("注册失败: " + e.getMessage());
                    }
                }

            }
        }).start();

    }
}
