package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity {

    Button btnReport, btnTravel, btnNews, btnHotel, btnEmergency, btnCurrency, btnTransport;
    ImageButton imbSetting;
    RelativeLayout rlvContainer;

    FragmentManager fm;

    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fm = getSupportFragmentManager();

        btnReport = findViewById(R.id.btn_report);
        btnHotel = findViewById(R.id.btn_hotel);
        btnNews = findViewById(R.id.btn_news);
        btnTravel = findViewById(R.id.btn_travel);
        btnCurrency = findViewById(R.id.btn_currency);
        btnTransport = findViewById(R.id.btn_transport);
        btnEmergency = findViewById(R.id.btn_emergency);

        rlvContainer = findViewById(R.id.rlv_container);

        imbSetting = findViewById(R.id.imb_settings);

        imbSetting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = fm.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                transaction.add(R.id.rlv_container, new MenuFragment());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

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

        btnCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCurrency = new Intent(HomeActivity.this, CurrencyActivity.class);
                startActivity(goToCurrency);
            }
        });

        btnEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToEmergency = new Intent(HomeActivity.this, ContactActivity.class);
                startActivity(goToEmergency);
            }
        });

        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTransport = new Intent(HomeActivity.this, TransportActivity.class);
                startActivity(goToTransport);
            }
        });
    }
}

