package com.example.ivf_dj.feature.lecture.mylecture;

import androidx.lifecycle.LiveData;

import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewmodel.RxViewModel;

public class MyLectureViewModel extends RxViewModel {
    private SingleLiveEvent<Void> mClickAddLectureEvent = new SingleLiveEvent<>();

    public void onCLickAddLecture(){
        mClickAddLectureEvent.call();
    }

    public LiveData<Void> getAddLectureEvent(){
        return mClickAddLectureEvent;
    }
}
