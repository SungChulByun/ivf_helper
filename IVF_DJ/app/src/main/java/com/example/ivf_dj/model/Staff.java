package com.example.ivf_dj.model;

import androidx.databinding.BaseObservable;

public class Staff extends BaseObservable {
    private String mail;
    private String name;

    public Staff(String mail, String name) {
        this.mail = mail;
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
