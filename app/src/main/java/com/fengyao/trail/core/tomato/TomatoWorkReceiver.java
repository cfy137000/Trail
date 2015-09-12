package com.fengyao.trail.core.tomato;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Chen fengYao on 2015/9/8.
 * 接收广播来启动BackToWorkActivity
 */
public class TomatoWorkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Sysout", "---->接受了广播");
        Intent backToWork = new Intent("com.fengyao.trail.tomato.BackToWorkActivity");
        backToWork.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(backToWork);
    }
}
