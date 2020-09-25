package com.example.ivf_dj.feature.login;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.ivf_dj.api.module.StaffFDBManager;
import com.example.ivf_dj.core.event.SingleLiveEvent;
import com.example.ivf_dj.core.viewmodel.RxViewModel;
import com.example.ivf_dj.model.User;
import com.example.ivf_dj.util.LoginManager;
import com.google.firebase.auth.FirebaseUser;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.ivf_dj.IVF_DJ.appLogin;
import static com.example.ivf_dj.api.module.StaffFDBManager.NOT_STAFF;

public class LoginViewModel extends RxViewModel {
    private final String TAG = "test_by_sungchul";
    private LoginManager mLoginManager = LoginManager.getInstance();
    private StaffFDBManager staffFDBManager = StaffFDBManager.getInstance();
    private User mUser;

    private SingleLiveEvent<Void> mSignInEvent = new SingleLiveEvent<>();
    private SingleLiveEvent<Void> mLoginEvent = new SingleLiveEvent<>();

    public void signIn() {
        mSignInEvent.call();
    }

    public void login(String idToken) {
        FirebaseUser firebaseUser = mLoginManager.getCurrentUser();
        mUser = new User(firebaseUser.getEmail(), idToken);
        checkIsStaff();
    }

    private void checkIsStaff() {
        mDisposable.add(staffFDBManager.isStaff(mUser.getMail())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> mLoginEvent.postCall())
                .subscribe(name -> {
                            if (!name.equals(NOT_STAFF)) {
                                mUser.setStaff(true);
                                mUser.setName(name);
                            }
                            appLogin(mUser);
                            Log.d(TAG, "checkIsStaff: staff name : " + name);
                        }
                        , error -> Log.d("error", "checkIsStaff: " + error.getMessage()))
        );
    }

    private void logout() {
        mLoginManager.logout();
    }

    public void onClickSighOutButton() {
        logout();
    }

    public LiveData<Void> getSignInEvent() {
        return mSignInEvent;
    }

    public LiveData<Void> getLoginEvent() {
        return mLoginEvent;
    }
}
