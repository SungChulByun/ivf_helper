package com.example.ivf_dj.feature.lecture.list.addLecture;

import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewModel.BaseViewModel;

import java.util.Calendar;

public class CalendarDialogViewModel extends BaseViewModel implements DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener {
    public static final int MINUTE_INTERVAL = 15;

    private SingleLiveEvent<Void> mCancelClickEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Long> mOkClickEvent = new SingleLiveEvent<>();

    private ObservableField<Integer> mCalendarYear = new ObservableField<>();
    private ObservableField<Integer> mCalendarMonthOfYear = new ObservableField<>();
    private ObservableField<Integer> mCalendarDayOfMonth = new ObservableField<>();
    private ObservableField<Integer> mCalendarHourOfDay = new ObservableField<>();
    private ObservableField<Integer> mCalendarMinute = new ObservableField<>();
    private Calendar mCurrentCalendar = Calendar.getInstance();

    public void start(long timeMills){
        updateCalendar(timeMills);
        mCalendarYear.set(mCurrentCalendar.get(Calendar.YEAR));
        mCalendarMonthOfYear.set(mCurrentCalendar.get(Calendar.MONTH));
        mCalendarDayOfMonth.set(mCurrentCalendar.get(Calendar.DAY_OF_MONTH));
        mCalendarHourOfDay.set(mCurrentCalendar.get(Calendar.HOUR_OF_DAY));
        mCalendarMinute.set(mCurrentCalendar.get(Calendar.MINUTE) / MINUTE_INTERVAL);
    }

    private void updateCalendar(long timeMills){
        mCurrentCalendar.setTimeInMillis(timeMills);
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        mCurrentCalendar.set(year, monthOfYear, dayOfMonth);
        Log.d("test_by_sungchul", "onDateChanged: year : " + year + ", monthOfYear : " + monthOfYear + ", datOfMonth : " + dayOfMonth);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        mCurrentCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        mCurrentCalendar.set(Calendar.MINUTE, minute * MINUTE_INTERVAL);

        Log.d("test_by_sungchul", "onDateChanged: hour : " + hourOfDay + ", minute : " + minute * MINUTE_INTERVAL);
    }

    public void onClickOKButton(){
        mOkClickEvent.setValue(mCurrentCalendar.getTimeInMillis());
    }

    public void onClickCancelButton(){
        mCancelClickEvent.call();
    }

    public LiveData<Void> getCancelClickEvent() {
        return mCancelClickEvent;
    }

    public LiveData<Long> getOkClickEvent() {
        return mOkClickEvent;
    }

    public ObservableField<Integer> getCalendarYear() {
        return mCalendarYear;
    }

    public ObservableField<Integer> getCalendarMonthOfYear() {
        return mCalendarMonthOfYear;
    }

    public ObservableField<Integer> getCalendarDayOfMonth() {
        return mCalendarDayOfMonth;
    }

    public ObservableField<Integer> getCalendarHourOfDay() {
        return mCalendarHourOfDay;
    }

    public ObservableField<Integer> getCalendarMinute() {
        return mCalendarMinute;
    }
}
