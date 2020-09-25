package com.example.ivf_dj.core.bindingadapter;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class SignInButtonBindingAdapter {
    @BindingAdapter("onClick")
    public static void setOnClick(View view, View.OnClickListener clickListener) {
        view.setOnClickListener(clickListener);
    }
}
