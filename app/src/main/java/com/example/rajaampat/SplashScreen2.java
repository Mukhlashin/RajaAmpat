package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashScreen2 extends AppCompatActivity {

    Button btnSplash02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen02);

        btnSplash02 = findViewById(R.id.btn_splash02);

        btnSplash02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSplash03 = new Intent(SplashScreen2.this, SplashScreen3.class);
                startActivity(goToSplash03);

            }
        });
    }
}