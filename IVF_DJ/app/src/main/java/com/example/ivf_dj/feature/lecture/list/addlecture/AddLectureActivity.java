package com.example.ivf_dj.feature.lecture.list.addlecture;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ivf_dj.R;
import com.example.ivf_dj.core.recyclerview.BaseRecyclerView;
import com.example.ivf_dj.databinding.ActivityAddLectureBinding;

public class AddLectureActivity extends AppCompatActivity {
    private ActivityAddLectureBinding mBinding;
    private AddLectureViewModel mViewModel;
    private BaseRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_lecture);
        initViews();
        initViewModel();
        initRecyclerView();
    }

    private void initViews(){
        mBinding.lectureNameEditText.setOnEditorActionListener((v, actionId, event) -> {
            if(actionId == EditorInfo.IME_ACTION_DONE){
                v.clearFocus();
                hideKeyboard(v);
                return true;
            }
            return false;
        });
    }

    private void hideKeyboard(View view){
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(AddLectureViewModel.class);

        mViewModel.getStartDateTimeClickEvent().observe(this, position -> {
            new CalendarDialog()
                    .setTimeMills(mViewModel.getLecture().getLectureTimeList().get(position).getStartTime())
                    .setPosition(position)
                    .setOnOkClickListener((pos, time) -> mViewModel.onChangeStartTimeMills(pos, time))
                    .show(this);
        });

        mBinding.setViewModel(mViewModel);
    }

    private void initRecyclerView(){
        LectureTimeAdapter adapter = new LectureTimeAdapter(position -> mViewModel.onClickLectureTime(position));
        mRecyclerView = mBinding.lectureRecyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }
}