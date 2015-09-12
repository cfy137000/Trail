package com.fengyao.trail.base;

import android.app.Application;
import android.content.Context;

import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;


/**
 * Created by Chen fengYao on 2015/8/28.
 */
public class BaseApplication extends Application {
    public static Context applicationContext;
    private static BaseApplication instance;
    // login user name
    public final String PREF_USERNAME = "username";

    /**
     * 当前用户nickname,为了苹果推送不是userid而是昵称
     */
    public static String currentUserNick = "";


    /**
     * 全局的上下文.
     */
    private static Context mContext;

    /**获取Context.
     * @return
     */
    public static Context getContext(){
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        EMChat.getInstance().init(this);

        EMChatManager.getInstance().getChatOptions().setUseRoster(true);
    }


}
