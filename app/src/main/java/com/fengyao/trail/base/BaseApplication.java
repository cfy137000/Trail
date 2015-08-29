package com.fengyao.trail.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Chen fengYao on 2015/8/28.
 */
public class BaseApplication extends Application {
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
    }
}
