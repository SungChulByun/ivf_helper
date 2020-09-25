package com.example.ivf_dj.feature.lecture.list.addlecture;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;

import com.example.ivf_dj.api.module.LectureFDBManager;
import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewmodel.BaseViewModel;
import com.example.ivf_dj.model.Lecture;
import com.example.ivf_dj.util.CalendarHelper;
import com.example.ivf_dj.util.StringUtility;

public class AddLectureViewModel extends BaseViewModel {
    private final String pattern = "yyyy년 MM월 dd일 E요일 a hh:mm";

    private LectureFDBManager lectureFDBManager = LectureFDBManager.getInstance();

    private SingleLiveEvent<Integer> mStartDateTimeClickEvent = new SingleLiveEvent<>();

    private ObservableArrayList<Long> mLectureTimeList = new ObservableArrayList<>();
    private ObservableInt mRunningTimeHour = new ObservableInt();
    private ObservableInt mRunningTimeMinute = new ObservableInt();
    private ObservableBoolean mLectureReadyToCreate = new ObservableBoolean();

    private boolean mStartTimeChanged = false;

    private Lecture mLecture = new Lecture();

    public AddLectureViewModel() {
        mLectureTimeList.add(System.currentTimeMillis());
        mLectureTimeList.add((long) 0);
    }

    public LiveData<Integer> getStartDateTimeClickEvent() {
        return mStartDateTimeClickEvent;
    }

    public Lecture getLecture() {
        return mLecture;
    }

    public void onChangeStartTimeMills(int position, long startTimeMills) {
        Log.d("test_by_sungchul", "onChangeStartTimeMills: position : " + position + ", time : " + CalendarHelper.makeStandardTimeText(startTimeMills));
        mStartTimeChanged = true;
        mLectureTimeList.set(position, startTimeMills);
        mLecture.setLectureStartTime(position, startTimeMills);
        checkIsLectureReady();
    }

    public void onClickLectureTime(int position) {
        if (mLectureTimeList.get(position) == 0) {
            addNewTime();
        } else {
            mStartDateTimeClickEvent.setValue(position);
        }
    }

    public void addNewTime() {
        mLectureTimeList.add(mLectureTimeList.size() - 1, System.currentTimeMillis());
        mLecture.addNewLecture();
    }

    public void onClickCreateLecture() {

        lectureFDBManager.addLecture(mLecture);
    }

    private void setPresenter() {
//        mLecture.setPresenter();
    }

    public ObservableArrayList<Long> getLectureTimeList() {
        return mLectureTimeList;
    }

    public ObservableInt getRunningTimeHour() {
        return mRunningTimeHour;
    }

    public ObservableInt getRunningTimeMinute() {
        return mRunningTimeMinute;
    }

    public ObservableBoolean getLectureReadyToCreate() {
        return mLectureReadyToCreate;
    }

    public void checkIsLectureReady() {
        boolean isReady = (mRunningTimeHour.get() + mRunningTimeMinute.get() > 0)
                && (mStartTimeChanged)
                && (!StringUtility.isNullOrEmpty(mLecture.getLectureName()))
                && (!StringUtility.isNullOrEmpty(mLecture.getDescription()))
                && (!StringUtility.isNullOrEmpty(mLecture.getTarget()));

        mLectureReadyToCreate.set(isReady);
    }

    private TextViewBindingAdapter.OnTextChanged onTextChanged = (s, start, before, count) -> checkIsLectureReady();

    public TextViewBindingAdapter.OnTextChanged getOnTextChanged() {
        return onTextChanged;
    }

}
