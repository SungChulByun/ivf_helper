package com.example.ivf_dj.feature.edit.staff;

import androidx.lifecycle.LiveData;

import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewmodel.RxViewModel;

public class ManageStaffViewModel extends RxViewModel {
    private SingleLiveEvent<Void> mClickAddStaffEvent = new SingleLiveEvent<>();

    public void onClickAddStaff() {
        mClickAddStaffEvent.call();
    }

    public LiveData<Void> getClickAddStaffEvent() {
        return mClickAddStaffEvent;
    }
}
