package com.example.ivf_dj.feature.login;

import com.example.ivf_dj.core.viewModel.RxViewModel;
import com.example.ivf_dj.util.LoginManager;

public class LoginViewModel extends RxViewModel {
    private final String TAG = "test_by_sungchul";
    private LoginManager mLoginManager = LoginManager.getInstance();

    private void logout() {
        mLoginManager.logout();
    }

    public void onClickSighOutButton() {
        logout();
    }
}
