package com.example.ivf_dj.feature.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.ivf_dj.R;
import com.example.ivf_dj.databinding.ActivityMainBinding;
import com.example.ivf_dj.util.LoginManager;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Todo SourceTree 브랜치 먼저!!!
    }
}