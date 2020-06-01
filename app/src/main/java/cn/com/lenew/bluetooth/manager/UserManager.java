package cn.com.lenew.bluetooth.manager;

import android.content.Context;

import cn.com.lenew.bluetooth.bean.UserInfo;
import cn.com.lenew.bluetooth.utils.SharedPreferenceUtil;

/**
 * Created by xuhuan 0008.
 */
public class UserManager {

    public static final String NICK_NAME = "nickName";
    public static final String USER_ID = "address";

    private static UserInfo myUser;

    public static UserInfo getMyUser(Context context){
        if(myUser == null){
            myUser = new UserInfo();

            String nickName = SharedPreferenceUtil.getInstance(context).getString(NICK_NAME);
            String userId = SharedPreferenceUtil.getInstance(context).getString(USER_ID);

            myUser.setNickName(nickName);
            myUser.setUserId(userId);
        }
        return myUser;
    }

    public static void setMyUserId(Context context, String userId){
        SharedPreferenceUtil.getInstance(context).putString(USER_ID,userId);
        if(myUser == null){
            getMyUser(context);
        }
        myUser.setUserId(userId);
    }

    public static void setMyUserNickName(Context context, String userName){
        SharedPreferenceUtil.getInstance(context).putString(NICK_NAME,userName);
        if(myUser == null){
            getMyUser(context);
        }
        myUser.setNickName(userName);
    }


}
