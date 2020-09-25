package com.example.ivf_dj.core.bindingadapter;

import android.util.Log;

import androidx.databinding.BindingAdapter;

import com.example.ivf_dj.core.recyclerview.BaseRecyclerView;
import com.example.ivf_dj.core.recyclerview.BaseRecyclerViewAdapter;

import java.util.List;

public class RecyclerViewBindingAdapter {

    @BindingAdapter(value = "bind:itemList")
    public static void setItemList(BaseRecyclerView recyclerView, List<?> itemList){
        if(recyclerView == null || recyclerView.getAdapter() == null){
            Log.d("test_by_sungchul", "setItemList: null");
            return;
        }

        Log.d("test_by_sungchul", "setItemList: not null, list size : " + itemList.size());
        recyclerView.getAdapter().setList(itemList);
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
