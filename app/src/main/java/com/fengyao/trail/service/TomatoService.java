package com.fengyao.trail.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import com.fengyao.trail.TomatoWorkAidlInterface;
import com.fengyao.trail.data.SQLTool;
import com.fengyao.trail.data.tables.SettingUserTable;

import java.util.List;

/**
 * Created by Chen fengYao on 2015/9/7.
 * 番茄的服务
 */
public class TomatoService extends Service {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            ComponentName topActivity = mActivityManager.getRunningTasks(1).get(0).topActivity;

            if (topActivity.getPackageName().equals("com.tencent.mm")) {
                Log.i("Sysout", "微信");
                Intent intent = new Intent("com.fengyao.trail.tomato.BackToWorkActivity");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Log.i("Sysout", "<-------发送广播了");
                Intent intentTmp = new Intent("com.fengyao.trail.core.tomato.BACK_TO_WORK");
                sendBroadcast(intentTmp);
            }
            sendEmptyMessageDelayed(0, 50);
        }
    };

    IBinder iBinder = new TomatoWorkAidlInterface.Stub() {


        @Override
        public void startTomato() throws RemoteException {
            Log.i("Sysout", "----->startTomato<-----");
            handler.sendEmptyMessage(0);
        }


        @Override
        public void stopTomato() throws RemoteException {
            handler.removeMessages(0);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
}
