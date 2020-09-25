package com.example.ivf_dj.feature.lecture.list.addlecture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.ivf_dj.R;
import com.example.ivf_dj.databinding.CalendarDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class CalendarDialog extends BottomSheetDialogFragment {
    private CalendarDialogBinding mBinding;
    private CalendarDialogViewModel mViewModel;
    private OnOkClickListener mOkClickListener;
    private long mTimeMills;
    private int position;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.calendar_dialog, container, false);
        mViewModel = new ViewModelProvider(this).get(CalendarDialogViewModel.class);

        mBinding.setViewModel(mViewModel);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        observeViewModel();
        mViewModel.start(mTimeMills, position);
    }

    private void observeViewModel() {
        mViewModel.getCancelClickEvent().observe(this, aVoid -> dismiss());

        mViewModel.getOkClickEvent().observe(this, time -> {
            if (mOkClickListener != null) {
                mOkClickListener.onClick(position, time);
            }
            dismiss();
        });
    }

    public CalendarDialog setOnOkClickListener(OnOkClickListener listener){
        this.mOkClickListener = listener;
        return this;
    }

    public CalendarDialog setTimeMills(long timeMills){
        this.mTimeMills = timeMills;
        return this;
    }

    public CalendarDialog setPosition(int position){
        this.position = position;
        return this;
    }

    public void show(FragmentActivity activity) {
        if (activity == null) {
            return;
        }

        String tag = getDialogTag();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        if (isAlreadyShowing(fragmentManager, tag)) {
            return;
        }

        show(fragmentManager, tag);
    }

    public String getDialogTag() {
        return getClass().getSimpleName();
    }


    private boolean isAlreadyShowing(FragmentManager fragmentManager, String tag) {
        return fragmentManager.findFragmentByTag(tag) != null;
    }

    public interface OnOkClickListener {
        void onClick(int position, long time);
    }
}
