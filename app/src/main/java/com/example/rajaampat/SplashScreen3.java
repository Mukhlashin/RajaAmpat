package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rajaampat.activity.logRegActivity.LoginActivity;

public class SplashScreen3 extends AppCompatActivity {

    Button btnSplash03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen03);

        btnSplash03 = findViewById(R.id.btn_splash03);

        btnSplash03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLogin = new Intent(SplashScreen3.this, LoginActivity.class);
                startActivity(goToLogin);

            }
        });
    }
}