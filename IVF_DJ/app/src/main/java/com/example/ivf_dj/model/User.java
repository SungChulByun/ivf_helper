package com.example.ivf_dj.model;

import androidx.databinding.BaseObservable;

public class User extends BaseObservable {
    private String mail;
    private String name;
    private boolean staff;

    public User(String mail, String name) {
        this.mail = mail;
        this.name = name;

    }
}
