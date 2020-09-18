package com.example.ivf_dj.feature.lecture.list;

import androidx.lifecycle.LiveData;

import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewModel.RxViewModel;

public class LectureListViewModel extends RxViewModel {
    private SingleLiveEvent<Void> mClickAddLectureButton = new SingleLiveEvent<>();

    public void onClickAddLectureButton(){
        mClickAddLectureButton.call();
    }

    public LiveData<Void> getClickLectureButton(){
        return mClickAddLectureButton;
    }

}
