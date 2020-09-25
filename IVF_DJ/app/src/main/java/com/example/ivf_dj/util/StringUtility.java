package com.example.ivf_dj.util;

public class StringUtility {
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

}
