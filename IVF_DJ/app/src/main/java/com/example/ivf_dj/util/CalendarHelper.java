package com.example.ivf_dj.util;

import androidx.databinding.InverseMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarHelper {
    private static String pattern = "yyyy년 MM월 dd일 E요일 a hh:mm";
    private static SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.KOREA);

    @InverseMethod(value = "stringToTime")
    public static String makeStandardTimeText(long time){
        return sdf.format(time);
    }

    public static long stringToTime(String text){
        long time = 0;

        try {
            Date date = sdf.parse(text);
            time = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return time;
    }
}
