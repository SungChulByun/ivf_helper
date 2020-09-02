package com.example.ivf_dj.core.event;

import androidx.lifecycle.MutableLiveData;

public class SingleLiveEvent<T> extends MutableLiveData<T> {
    public void call() {
        this.setValue(null);
    }

    public void postCall() {
        super.postValue(null);
    }
}
