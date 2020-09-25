package com.example.ivf_dj.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.ivf_dj.BR;

public class User extends BaseObservable {
    private String mail;
    private String name;
    private String idToken;
    private boolean staff;

    public User(String mail, String idToken) {
        this.mail = mail;
        this.idToken = idToken;
        staff = false;
    }

    @Bindable
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
        notifyPropertyChanged(BR.mail);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
        notifyPropertyChanged(BR.idToken);
    }

    @Bindable
    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
        notifyPropertyChanged(BR.staff);
    }
}
