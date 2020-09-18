package com.example.ivf_dj.feature.lecture.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.ivf_dj.R;
import com.example.ivf_dj.databinding.ActivityLectureListBinding;
import com.example.ivf_dj.util.RedirectHelper;

public class LectureListActivity extends AppCompatActivity {
    private ActivityLectureListBinding mBinding;
    private LectureListViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lecture_list);

        initViewModel();
    }

    private void initViewModel(){
        mViewModel = new ViewModelProvider(this).get(LectureListViewModel.class);

        mViewModel.getClickLectureButton().observe(this, aVoid -> RedirectHelper.startAddLectureActivity(this));

        mBinding.setViewModel(mViewModel);
    }
}