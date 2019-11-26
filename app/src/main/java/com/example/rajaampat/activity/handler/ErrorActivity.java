package com.example.rajaampat.activity.handler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rajaampat.R;
import com.example.rajaampat.activity.homeActivity.HomeActivity;

public class ErrorActivity extends AppCompatActivity {

    Button btnLetMeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error_layout);

        btnLetMeIn = findViewById(R.id.btn_let_me_in);

        btnLetMeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ErrorActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
