package cn.com.lenew.bluetooth.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import cn.com.lenew.bluetooth.manager.UserManager;
import cn.com.lenew.bluetooth.utils.BluetoothUtils;

/**
 * Created by xuhuan 0010.
 */
public class ServerService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(BluetoothUtils.getInstance(this).startServerThread==null){
            BluetoothUtils.getInstance(this).initServer();
            UserManager.setMyUserId(this, BluetoothUtils.getInstance(this).getBluetoothAdapter().getAddress());

            String add = BluetoothUtils.getInstance(this).getBluetoothAdapter().getAddress();
            System.out.print(add);
        }

        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        BluetoothUtils.getInstance(this).onDestroy();
        super.onDestroy();
    }
}
