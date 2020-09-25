package com.example.ivf_dj.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.ivf_dj.BR;

import java.util.ArrayList;
import java.util.List;

public class Lecture extends BaseObservable {
    private int lectureId;
    private String lectureName;
    private List<LectureTime> lectureTimeList;
    private String presenter;
    private String description;
    private String target;

    //Todo Image
    public Lecture(){
        this.lectureTimeList = createLectureTimeList(System.currentTimeMillis());
    }

    public Lecture(String lectureName, long startTime, String presenter, String description, String target) {
        this.lectureName = lectureName;
        this.lectureTimeList = createLectureTimeList(startTime);
        this.presenter = presenter;
        this.description = description;
        this.target = target;
    }

    private List<LectureTime> createLectureTimeList(long startTime){
        List<LectureTime> list = new ArrayList<>();
        list.add(new LectureTime(startTime));

        return  list;
    }

    @Bindable
    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
        notifyPropertyChanged(BR.lectureName);
    }

    public List<LectureTime> getLectureTimeList() {
        return lectureTimeList;
    }

    public void setLectureStartTime(int position, long startTime) {
        this.lectureTimeList.get(position).setStartTime(startTime);
    }

    public void addNewLecture(){
        lectureTimeList.add(new LectureTime(System.currentTimeMillis()));
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
