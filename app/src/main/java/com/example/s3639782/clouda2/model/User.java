package com.example.s3639782.clouda2.model;

import com.google.android.gms.maps.model.LatLng;

public class User {

    private String mUUID;
    private String mUserName;
    private String mEmail;
    private String Age;
    private String phone;
    private LatLng Location;


    public User() {
    }


    public String getmUUID() {
        return mUUID;
    }

    public void setmUUID(String mUUID) {
        this.mUUID = mUUID;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }


    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LatLng getLocation() {
        return Location;
    }

    public void setLocation(LatLng location) {
        Location = location;
    }
}
