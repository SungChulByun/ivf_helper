package com.example.ivf_dj.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class CalendarHelper {

    public static String makeTimeText(long time, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.KOREA);
        return sdf.format(time);
    }
}
