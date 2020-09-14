package com.example.ivf_dj.util;

import android.app.Activity;
import android.content.Intent;

import com.example.ivf_dj.feature.lecture.list.LectureListActivity;
import com.example.ivf_dj.feature.lecture.signUp.SignUpLectureActivity;
import com.example.ivf_dj.feature.main.MainActivity;
import com.example.ivf_dj.feature.notification.NotificationActivity;
import com.example.ivf_dj.feature.timeTable.TimeTableActivity;

public class RedirectHelper {
    public static void startMainActivity(Activity context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void startLectureListActivity(Activity context){
        Intent intent = new Intent(context, LectureListActivity.class);
        context.startActivity(intent);
    }

    public static void startSignUpLectureActivity(Activity context){
        Intent intent = new Intent(context, SignUpLectureActivity.class);
        context.startActivity(intent);
    }

    public static void startNotificationActivity(Activity context){
        Intent intent = new Intent(context, NotificationActivity.class);
        context.startActivity(intent);
    }

    public static void startTimeTableActivity(Activity context){
        Intent intent = new Intent(context, TimeTableActivity.class);
        context.startActivity(intent);
    }
}
