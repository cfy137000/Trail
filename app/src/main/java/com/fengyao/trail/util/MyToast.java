package com.fengyao.trail.util;

import android.widget.Toast;

import com.fengyao.trail.base.BaseApplication;

/**
 * Created by Chen fengYao on 2015/9/2.
 * 可以随时吐司
 */
public class MyToast {
    public static void mToast(String msg){
        Toast.makeText(BaseApplication.getContext(),msg+"",Toast.LENGTH_SHORT).show();
    }
}
