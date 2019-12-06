package com.example.rajaampat.model.modelForgotPassword;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordDataItem {

    @SerializedName("email;")
    private String email;

    public String getEmail(){
        return email;
    }

    @Override
    public String toString(){
        return
                "ForgotPasswordDataItem{" +
                        "email = '" + email + '\'' +
                        "}";
    }
}