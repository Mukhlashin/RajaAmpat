package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class DestinationActivity extends AppCompatActivity {

    ImageButton imbBack;

    LinearLayout btnDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        imbBack = findViewById(R.id.imb_back);

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToDetail = new Intent(DestinationActivity.this, DetailDestinationActivity.class);
                startActivity(goToDetail);
            }
        });

        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHome = new Intent(DestinationActivity.this, HomeActivity.class);
                startActivity(goToHome);
            }
        });

    }
}
