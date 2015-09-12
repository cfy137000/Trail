package com.fengyao.trail.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.fengyao.trail.TomatoWorkAidlInterface;

/**
 * Created by Chen fengYao on 2015/9/7.
 * 番茄时钟的服务管理累
 */
public class TomatoServiceManager {
    private TomatoWorkAidlInterface tomatoWorkAidlInterface;

    private static final TomatoServiceManager tomatoServiceManager = new TomatoServiceManager();

    Intent intent = new Intent();

    private TomatoServiceManager() {
        intent.setAction("com.fengyao.trail.service");
        intent.setPackage("com.fengyao.trail");
    }

    public static TomatoServiceManager getInstance() {
        return tomatoServiceManager;
    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            tomatoWorkAidlInterface = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            tomatoWorkAidlInterface = TomatoWorkAidlInterface.Stub.asInterface(service);
        }
    };


    /**
     * 启动service
     *
     * @param context
     * @return
     */
    public boolean startService(Context context) {
        ComponentName name = context.startService(intent);
        if (name == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 停止服务
     *
     * @param context
     * @return
     */
    public boolean stopService(Context context) {
        return context.stopService(intent);
    }

    //绑定服务
    public boolean bindService(Context context) {
        return context.bindService(intent, connection, Context.BIND_ABOVE_CLIENT);
    }

    public void startTomatoWork() {
        if (tomatoWorkAidlInterface == null) {
            return;
        }
        try {
            tomatoWorkAidlInterface.startTomato();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void stopTomatoWork() {
        if (tomatoWorkAidlInterface == null) {
            return;
        }
        try {
            tomatoWorkAidlInterface.stopTomato();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
