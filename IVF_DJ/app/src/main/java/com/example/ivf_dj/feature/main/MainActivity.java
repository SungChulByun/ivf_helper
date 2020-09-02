package com.example.ivf_dj.feature.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ivf_dj.R;
import com.example.ivf_dj.util.LoginManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.sign_out_button).setOnClickListener(v -> {
            LoginManager.getInstance().logout();
            onBackPressed();
        });
    }
}