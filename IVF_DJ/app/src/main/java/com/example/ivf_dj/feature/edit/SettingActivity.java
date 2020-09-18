package com.example.ivf_dj.feature.edit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.ivf_dj.R;
import com.example.ivf_dj.databinding.ActivitySettingBinding;
import com.example.ivf_dj.model.LectureTime;

public class SettingActivity extends AppCompatActivity {
    private ActivitySettingBinding mBinding;
    private SettingViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_setting);

        initViewModel();

    }

    private void initViewModel(){
        mViewModel = new ViewModelProvider(this).get(SettingViewModel.class);

        mBinding.setViewModel(mViewModel);
    }
}