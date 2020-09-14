package com.example.ivf_dj.util;

import android.content.Context;
import android.content.Intent;

import com.example.ivf_dj.feature.main.MainActivity;

public class RedirectHelper {
    public static void startMainActivity(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
