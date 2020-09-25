package com.example.ivf_dj.feature.lecture.list.addlecture;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ivf_dj.R;
import com.example.ivf_dj.core.recyclerview.BaseRecyclerViewAdapter;
import com.example.ivf_dj.core.recyclerview.ItemClickListener;
import com.example.ivf_dj.databinding.HolderLectureTimeBinding;

public class LectureTimeAdapter extends BaseRecyclerViewAdapter {
    public LectureTimeAdapter(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public LectureTimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        HolderLectureTimeBinding binding = DataBindingUtil.inflate(inflater, R.layout.holder_lecture_time, parent, false);

        return new LectureTimeHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LectureTimeHolder lectureTimeHolder = (LectureTimeHolder) holder;

        lectureTimeHolder.bind(position, (long) mList.get(position));
        lectureTimeHolder.binding.getRoot().setOnClickListener(v -> mItemClickListener.clickItem(position));
    }


    private static class LectureTimeHolder extends RecyclerView.ViewHolder {
        HolderLectureTimeBinding binding;

        public LectureTimeHolder(@NonNull HolderLectureTimeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int position, long timeMills) {
            binding.setPosition(position);
            binding.setTime(timeMills);
            binding.executePendingBindings();
        }
    }
}


