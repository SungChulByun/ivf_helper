package com.example.ivf_dj.core.viewmodel;

import io.reactivex.disposables.CompositeDisposable;

public class RxViewModel extends BaseViewModel {
    protected CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCleared() {
        if(mDisposable != null){
            mDisposable.clear();
        }
        super.onCleared();
    }
}
