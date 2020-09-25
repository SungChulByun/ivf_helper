package com.example.ivf_dj.util.converter;

import androidx.databinding.InverseMethod;

import com.example.ivf_dj.util.StringUtility;

public class Converter {
    @InverseMethod(value = "integerToString")
    public static int stringToInteger(String value) {
        if (StringUtility.isNullOrEmpty(value)) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    public static String integerToString(int value) {
        return String.valueOf(value);
    }
}
