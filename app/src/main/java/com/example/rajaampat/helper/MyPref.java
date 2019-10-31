package com.example.rajaampat.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.rajaampat.LoginActivity;
import com.example.rajaampat.model.ResponseUser;

public class MyPref extends LoginActivity {

    private static final String PREF_NAME = "userPref";
    private static final int PREF_MODE = Context.MODE_PRIVATE;

    private SharedPreferences myPref;
    private Context context;
    private SharedPreferences.Editor editor;

    public MyPref(Context context) {
        this.context = context;

    }

    public String getUserId() {
        return myPref.getString("id", null);
    }

    public String getUserName() {
        return myPref.getString("nama", null);
    }

    public String getUserEmail() {
        return myPref.getString("email", null);
    }

    public String getUserPass() {
        return myPref.getString("pass", null);
    }

    public void deleteUser() {
        editor = myPref.edit();
        editor
                .clear()
                .commit();
    }
}
