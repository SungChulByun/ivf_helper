package com.example.ivf_dj.feature.main;

import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewModel.BaseViewModel;

public class MainViewModel extends BaseViewModel {
    private SingleLiveEvent<Void> mClickSignUpLectureEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mClickLectureListEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mClickTimeTableEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mClickNotificationEvent = new SingleLiveEvent<>();

    public void onClickSignUpLecture() {
        mClickSignUpLectureEvent.call();
    }

    public void onClickLectureList() {
        mClickLectureListEvent.call();
    }

    public void onClickTimeTable() {
        mClickTimeTableEvent.call();
    }

    public void onClickNotification() {
        mClickNotificationEvent.call();
    }

    public SingleLiveEvent<Void> getClickSignUpLectureEvent() {
        return mClickSignUpLectureEvent;
    }

    public SingleLiveEvent<Void> getClickLectureListEvent() {
        return mClickLectureListEvent;
    }

    public SingleLiveEvent<Void> getClickTimeTableEvent() {
        return mClickTimeTableEvent;
    }

    public SingleLiveEvent<Void> getClickNotificationEvent() {
        return mClickNotificationEvent;
    }
}
