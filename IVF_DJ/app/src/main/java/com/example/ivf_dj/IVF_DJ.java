package com.example.ivf_dj;

import android.app.Application;
import android.content.Context;

public class IVF_DJ extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getAppContext(){
        return mContext;
    }
}
