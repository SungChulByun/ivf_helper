package com.example.ivf_dj.feature.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.ivf_dj.R;
import com.example.ivf_dj.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding mBinding;
    private LoginViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        initViewModel();
        initViews();
    }

    private void initViewModel(){
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        mBinding.setViewModel(mViewModel);
    }

    private void initViews(){

    }
}