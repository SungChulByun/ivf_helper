package com.example.ivf_dj.util;

import android.content.Context;

import com.example.ivf_dj.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.ivf_dj.IVF_DJ.getAppContext;

public class LoginManager {
    private static LoginManager instance;
    private GoogleSignInClient mGoogleSignInClient;
    private Context mContext = getAppContext();
    private FirebaseAuth mAuth;

    public static LoginManager getInstance() {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    public LoginManager() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(mContext.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(mContext, gso);
        mAuth = FirebaseAuth.getInstance();
    }

    public GoogleSignInClient getGoogleSignInClient() {
        return mGoogleSignInClient;
    }

    public void logout(){
        mGoogleSignInClient.signOut();
        mAuth.signOut();
    }

    public FirebaseAuth getAuth(){
        return mAuth;
    }

    public FirebaseUser getCurrentUser(){
        return mAuth.getCurrentUser();
    }
}
