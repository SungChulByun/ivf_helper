package com.example.ivf_dj.feature.edit.staff;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.ivf_dj.R;
import com.example.ivf_dj.databinding.ActivityManageStaffBinding;

public class ManageStaffActivity extends AppCompatActivity {
    private ActivityManageStaffBinding mBinding;
    private ManageStaffViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_manage_staff);

        initViewModel();
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(ManageStaffViewModel.class);

        mViewModel.getClickAddStaffEvent().observe(this, );

        mBinding.setViewModel(mViewModel);
    }


}