package com.example.ivf_dj.core.bindingAdapter;

import android.content.res.Resources;
import android.os.Build;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import androidx.databinding.BindingAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.ivf_dj.feature.lecture.list.addLecture.CalendarDialogViewModel.MINUTE_INTERVAL;

public class CalendarBindingAdapter {
    @BindingAdapter(value = {"calendarYear", "calendarMonthOfYear", "calendarDayOfMonth", "onDateChanged"}, requireAll = false)
    public static void setDate(DatePicker view, int year, int month, int day, DatePicker.OnDateChangedListener listener) {
        view.init(year, month, day, listener);
    }

    @BindingAdapter(value = {"calendarHourOfDay", "calendarMinute", "onTimeChanged"}, requireAll = false)
    public static void setTime(TimePicker view, int hour, int minute, TimePicker.OnTimeChangedListener listener) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.setHour(hour);
            view.setMinute(minute);
        } else {
            view.setCurrentHour(hour);
            view.setCurrentMinute(minute);
        }

        setMinuteInterval(view, MINUTE_INTERVAL);
        view.setOnTimeChangedListener(listener);
    }

    private static void setMinuteInterval(TimePicker view, int minuteInterval) {
        if (minuteInterval > 0 && minuteInterval <= 30) {
            NumberPicker minutePicker = view.findViewById(Resources.getSystem().getIdentifier("minute", "id", "android"));
            minutePicker.setMinValue(0);
            minutePicker.setMaxValue((60 / minuteInterval) - 1);
            List<String> displayedValues = new ArrayList<>();
            for (int i = 0; i < 60; i += minuteInterval) {
                displayedValues.add(String.format("%02d", i));
            }
            minutePicker.setDisplayedValues(displayedValues.toArray(new String[0]));
        }
    }
}
