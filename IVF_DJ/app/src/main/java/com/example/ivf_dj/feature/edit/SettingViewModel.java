package com.example.ivf_dj.feature.edit;

import androidx.lifecycle.LiveData;

import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewmodel.RxViewModel;

public class SettingViewModel extends RxViewModel {
    private SingleLiveEvent<Void> mClickSearchEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mClickManageStaffEvent = new SingleLiveEvent<>();

    public void onClickEditLecture() {
        mClickSearchEvent.call();
    }

    public void onClickManageStaff() {
        mClickManageStaffEvent.call();
    }

    public LiveData<Void> getClickSearchEvent() {
        return mClickSearchEvent;
    }

    public LiveData<Void> getClickManageStaffEvent() {
        return mClickManageStaffEvent;
    }
}
