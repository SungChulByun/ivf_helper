package com.example.ivf_dj.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.ivf_dj.BR;

public class LectureTime extends BaseObservable {
    private long startTime;
    private int runningTime;


    public LectureTime(long startTime) {
        this.startTime = startTime;
    }

    @Bindable
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
        notifyPropertyChanged(BR.startTime);
    }

    @Bindable
    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
        notifyPropertyChanged(BR.runningTime);
    }

}
