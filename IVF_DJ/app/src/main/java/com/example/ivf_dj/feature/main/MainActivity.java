package com.example.ivf_dj.feature.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.ivf_dj.R;
import com.example.ivf_dj.databinding.ActivityMainBinding;
import com.example.ivf_dj.util.RedirectHelper;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Todo SourceTree 브랜치 먼저!!!
        initViewModel();
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.getClickMyLectureEvent().observe(this, aVoid -> RedirectHelper.startMyLectureActivity(this));

        mViewModel.getClickNotificationEvent().observe(this, aVoid -> RedirectHelper.startNotificationActivity(this));

        mViewModel.getClickLectureListEvent().observe(this, aVoid -> RedirectHelper.startLectureListActivity(this));

        mViewModel.getClickTimeTableEvent().observe(this, aVoid -> RedirectHelper.startTimeTableActivity(this));

        mViewModel.getClickSettingEvent().observe(this, aVoid -> RedirectHelper.startSettingActivity(this));

        mBinding.setViewModel(mViewModel);
    }
}