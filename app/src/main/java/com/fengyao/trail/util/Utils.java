package com.fengyao.trail.util;

import android.os.Vibrator;

import com.fengyao.trail.base.BaseApplication;

/**
 * Created by Chen fengYao on 2015/8/28.
 * 一些工具类
 */
public class Utils {
    private static Vibrator vibrator= (Vibrator) BaseApplication.getContext().getSystemService(BaseApplication.getContext().VIBRATOR_SERVICE);

    public static void shortShock(){
        vibrator.vibrate(300);
    }

}
