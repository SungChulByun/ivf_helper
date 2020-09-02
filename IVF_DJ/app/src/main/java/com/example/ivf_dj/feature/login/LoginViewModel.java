package com.example.ivf_dj.feature.login;

import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewModel.RxViewModel;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends RxViewModel {
    private final String TAG = "test_by_sungchul";
    private ObservableBoolean mIsLogin = new ObservableBoolean();
    private ObservableField<FirebaseUser> mAccount = new ObservableField<>();

    private SingleLiveEvent<Void> mSignOutButtonClickEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mDeleteButtonClickEvent = new SingleLiveEvent<>();

    public LoginViewModel() {
        mIsLogin.set(false);
    }

    public ObservableBoolean isLogin() {
        return mIsLogin;
    }

    public void loginSuccess() {
        mIsLogin.set(true);
        Log.d("test_by_sungchul", "loginSuccess: isLogin : " + mIsLogin.get());
    }

    public void logout(){
        mIsLogin.set(false);
        Log.d("test_by_sungchul", "logout // isLogin : " + mIsLogin.get());
    }

    public void updateAccount(FirebaseUser account) {
        if(account == null){
            Log.d(TAG, "updateAccount: null");
            return;
        }
        Log.d(TAG, "updateAccount: email : " + account.getEmail());
        Log.d(TAG, "updateAccount: phone number : " + account.getPhoneNumber());
        Log.d(TAG, "updateAccount: uid : " + account.getUid());
        loginSuccess();
        mAccount.set(account);
    }

    public ObservableField<FirebaseUser> getAccount() {
        return mAccount;
    }

    public void onClickSighOutButton(){
        logout();
        mSignOutButtonClickEvent.call();
    }

    public void onClickDeleteButton(){
        mDeleteButtonClickEvent.call();
    }

    public LiveData<Void> getSignOutButtonClickEvent(){
        return mSignOutButtonClickEvent;
    }

    public LiveData<Void> getDeleteButtonClickEvent(){
        return mDeleteButtonClickEvent;
    }
}
