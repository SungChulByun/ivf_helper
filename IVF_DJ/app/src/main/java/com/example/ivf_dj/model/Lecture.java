package com.example.ivf_dj.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.ivf_dj.BR;

public class Lecture extends BaseObservable {
    private int lectureId;
    private String lectureName;
    private LectureTime lectureTime;
    private String presenter;
    private String description;
    private String target;

    //Todo Image
    public Lecture(){
        this.lectureTime = new LectureTime(System.currentTimeMillis());
    }

    public Lecture(String lectureName, int startTime, String presenter, String description, String target) {
        this.lectureName = lectureName;
        this.lectureTime = new LectureTime(startTime);
        this.presenter = presenter;
        this.description = description;
        this.target = target;
    }

    @Bindable
    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
        notifyPropertyChanged(BR.lectureName);
    }

    public LectureTime getLectureTime() {
        return lectureTime;
    }

    public void setLectureStartTime(long startTime) {
        this.lectureTime.setStartTime(startTime);
    }

    @Bindable
    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
        notifyPropertyChanged(BR.presenter);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
        notifyPropertyChanged(BR.target);
    }

}
