package com.example.ivf_dj;

import android.app.Application;
import android.content.Context;

import com.example.ivf_dj.model.User;

public class IVF_DJ extends Application {
    private static Context mContext;
    private static User mUser;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getAppContext(){
        return mContext;
    }

    public static User getLoginUser(){
        return mUser;
    }

    public static void appLogin(User user){
        mUser = user;
    }
}
