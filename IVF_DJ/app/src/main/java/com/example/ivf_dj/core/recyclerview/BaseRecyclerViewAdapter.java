package com.example.ivf_dj.core.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
    private static final int POSITION_KEY = 3982;

    protected List<Object> mList;
    protected ItemClickListener mItemClickListener;

    public List<?> getList() {
        return mList;
    }

    public void setList(List<Object> list) {
        mList = list;
    }

    public ItemClickListener getItemClickListener() {
        return mItemClickListener;
    }

    public void setItemClickListener(ItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}
