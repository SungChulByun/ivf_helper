package com.example.ivf_dj.feature.lecture.list.addLecture;

import android.util.Log;

import androidx.databinding.ObservableLong;
import androidx.lifecycle.LiveData;

import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewModel.BaseViewModel;
import com.example.ivf_dj.model.Lecture;
import com.example.ivf_dj.util.CalendarHelper;

public class AddLectureViewModel extends BaseViewModel {
    private final String pattern = "yyyy년 MM월 dd일 E요일 a hh:mm";

    private SingleLiveEvent<Void> mStartDateTimeClickEvent = new SingleLiveEvent<>();

    private Lecture mLecture = new Lecture();

    public AddLectureViewModel() {
    }

    public void onClickStartDateTime() {
        mStartDateTimeClickEvent.call();
    }

    public LiveData<Void> getStartDateTimeClickEvent() {
        return mStartDateTimeClickEvent;
    }

    public Lecture getLecture() {
        return mLecture;
    }

    public void onChangeStartTimeMills(long startTimeMills) {
        mLecture.setLectureStartTime(startTimeMills);
        Log.d("test_by_sungchul", "onChangeStartTimeMills: startTime : " + makeTimeText(startTimeMills));
    }

    public String makeTimeText(long time){
        return CalendarHelper.makeTimeText(time, pattern);
    }
}
