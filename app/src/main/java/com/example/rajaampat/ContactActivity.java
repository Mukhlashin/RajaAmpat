package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ContactActivity extends AppCompatActivity {

    LinearLayout lnr_police, lnr_sms,lnr_emergency,lnr_money_changer,lnr_ambulance,lnr_immigration,lnr_tourism_center,lnr_hospital;
    String dial_tourism = "223";
    String dial_ambulance = "08111000222";
    String dial_emergency = "911";
    String dial_hospital = "223";
    String dial_immigration = "011";
    String dial_money_changer = "08111000221";
    String dial_sms = "08111000223";
    String dial_police = "08111000224";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        lnr_ambulance = findViewById(R.id.lnr_ambulance);
        lnr_emergency = findViewById(R.id.lnr_emergency);
        lnr_hospital = findViewById(R.id.lnr_hospital);
        lnr_immigration = findViewById(R.id.lnr_immigration);
        lnr_money_changer = findViewById(R.id.lnr_money_changer);
        lnr_sms = findViewById(R.id.lnr_sms);
        lnr_police = findViewById(R.id.lnr_police);
        lnr_tourism_center = findViewById(R.id.lnr_tourism_center);

        lnr_police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial(dial_police);
            }
        });

        lnr_hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial(dial_hospital);
            }
        });

        lnr_immigration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial(dial_immigration);
            }
        });

        lnr_ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial(dial_ambulance);
            }
        });

        lnr_money_changer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial(dial_money_changer);
            }
        });

        lnr_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial(dial_emergency);
            }
        });

        lnr_tourism_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial(dial_tourism);
            }
        });

        lnr_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dial(dial_sms);
            }
        });
    }

    public void dial(String dial_something) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + dial_something));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void back(View view) {
        super.onBackPressed();
    }
}
