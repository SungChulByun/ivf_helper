package com.example.ivf_dj.feature.lecture.list.addLecture;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.ivf_dj.R;
import com.example.ivf_dj.databinding.ActivityAddLectureBinding;

public class AddLectureActivity extends AppCompatActivity {
    private ActivityAddLectureBinding mBinding;
    private AddLectureViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_lecture);
        initViewModel();
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(AddLectureViewModel.class);

        mViewModel.getStartDateTimeClickEvent().observe(this, aVoid -> {
            new CalendarDialog()
                    .setTimeMills(mViewModel.getLecture().getLectureTime().getStartTime())
                    .setOnOkClickListener(time -> mViewModel.onChangeStartTimeMills(time))
                    .show(this);
        });

        mBinding.setViewModel(mViewModel);
    }
}