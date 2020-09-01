package com.example.ivf_dj.core.viewModel;

import io.reactivex.disposables.CompositeDisposable;

public class RxViewModel extends BaseViewModel {
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCleared() {
        if(compositeDisposable != null){
            compositeDisposable.clear();
        }
        super.onCleared();
    }
}
