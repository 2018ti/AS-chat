package cn.com.lenew.bluetooth.utils;

import android.util.Log;

/**
 * Created by xuhuan 0008.
 */
public class LogUtil {

    public static boolean isDebugMode = true;
    public static String TAG = "tag";

    public static void e(String msg){
        if(isDebugMode){
            Log.e(TAG,msg);
        }
    }

    public static void d(String msg){
        if(isDebugMode){
            Log.d(TAG,msg);
        }
    }

}
