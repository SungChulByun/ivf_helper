package com.example.ivf_dj.feature.main;

import androidx.lifecycle.LiveData;

import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewModel.BaseViewModel;

public class MainViewModel extends BaseViewModel {
    private SingleLiveEvent<Void> mClickSignUpLectureEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mClickLectureListEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mClickTimeTableEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mClickNotificationEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mClickSettingEvent = new SingleLiveEvent<>();

    public void onClickSignUpLecture() {
        mClickSignUpLectureEvent.call();
    }

    public void onClickLectureList() {
        mClickLectureListEvent.call();
    }

    public void onClickTimeTable() {
        mClickTimeTableEvent.call();
    }

    public void onClickSetting(){
        mClickSettingEvent.call();
    }

    public void onClickNotification() {
        mClickNotificationEvent.call();
    }

    public LiveData<Void> getClickSignUpLectureEvent() {
        return mClickSignUpLectureEvent;
    }

    public LiveData<Void> getClickLectureListEvent() {
        return mClickLectureListEvent;
    }

    public LiveData<Void> getClickTimeTableEvent() {
        return mClickTimeTableEvent;
    }

    public LiveData<Void> getClickNotificationEvent() {
        return mClickNotificationEvent;
    }

    public LiveData<Void> getClickSettingEvent(){
        return mClickSettingEvent;
    }
}
