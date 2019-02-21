package com.sparkdev.foodapp.models;

import java.util.ArrayList;

public class User {

    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String fullAddress;
    private ArrayList<String> preferences;

    public User(String email, String password, String address, String city, String state, String zipCode) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.fullAddress = address + city + state + zipCode;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void addPreference(String pref){
        preferences.add(pref);
    }

    public void delPreference(String pref){
        preferences.remove(pref);
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }
}
