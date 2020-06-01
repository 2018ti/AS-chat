package cn.com.lenew.bluetooth;

import android.app.Application;

import org.xutils.x;

import cn.com.lenew.bluetooth.utils.BluetoothUtils;
import cn.com.lenew.bluetooth.utils.CrashHandler;

/**
 * Created by lenovo on 2016/7/10 0010.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this);
        BluetoothUtils.getInstance(this);
        x.Ext.init(this);
    }
}
