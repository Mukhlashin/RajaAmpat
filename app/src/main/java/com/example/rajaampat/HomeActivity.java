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

    Button btnReport, btnTravel, btnNews, btnHotel, btnEmc, btnTrans, btnCur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnReport = findViewById(R.id.btn_report);
        btnHotel = findViewById(R.id.btn_hotel);
        btnNews = findViewById(R.id.btn_news);
        btnTravel = findViewById(R.id.btn_travel);
        btnEmc = findViewById(R.id.btn_emc);
        btnTrans = findViewById(R.id.btn_trans);
        btnCur = findViewById(R.id.btn_cur);

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

        btnEmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToEmergency = new Intent(HomeActivity.this, ContactActivity.class);
                startActivity(goToEmergency);
            }
        });

        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTransport = new Intent(HomeActivity.this, TransportActivity.class);
                startActivity(goToTransport);
            }
        });

        btnCur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCurrency = new Intent(HomeActivity.this, CurrencyActivity.class);
                startActivity(goToCurrency);
            }
        });
    }
}

