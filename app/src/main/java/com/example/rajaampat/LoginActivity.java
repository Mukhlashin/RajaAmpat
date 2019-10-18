package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToHome(View view) {
        Intent goToHome = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(goToHome);
    }

    public void goToRegister(View view) {
        Intent goToRegister = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(goToRegister);
    }
}
