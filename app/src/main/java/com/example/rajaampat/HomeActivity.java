package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity {

    Button btnReport, btnTravel, btnNews, btnHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnReport = findViewById(R.id.btn_report);
        btnHotel = findViewById(R.id.btn_hotel);
        btnNews = findViewById(R.id.btn_news);
        btnTravel = findViewById(R.id.btn_travel);

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToReport = new Intent(HomeActivity.this, ReportActivity.class);
                startActivity(goToReport);
            }
        });

        btnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHotel = new Intent(HomeActivity.this, HotelActivity.class);
                startActivity(goToHotel);
            }
        });

        btnTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTravel = new Intent(HomeActivity.this, TransportActivity.class);
                startActivity(goToTravel);
            }
        });

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNews = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(goToNews);
            }
        });
    }
}

