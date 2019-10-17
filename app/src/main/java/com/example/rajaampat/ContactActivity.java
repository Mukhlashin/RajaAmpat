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

    ImageButton imbHome;

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

        imbHome = findViewById(R.id.imb_home);
        lnr_ambulance = findViewById(R.id.lnr_ambulance);
        lnr_emergency = findViewById(R.id.lnr_emergency);
        lnr_hospital = findViewById(R.id.lnr_hospital);
        lnr_immigration = findViewById(R.id.lnr_immigration);
        lnr_money_changer = findViewById(R.id.lnr_money_changer);
        lnr_sms = findViewById(R.id.lnr_sms);
        lnr_police = findViewById(R.id.lnr_police);
        lnr_tourism_center = findViewById(R.id.lnr_tourism_center);

        lnr_tourism_center.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dial(dial_tourism);
                return false;
            }
        });

        lnr_police.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dial(dial_police);
                return false;
            }
        });

        lnr_sms.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dial(dial_sms);
                return false;
            }
        });

        lnr_money_changer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dial(dial_money_changer);
                return false;
            }
        });

        lnr_emergency.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dial(dial_emergency);
                return false;
            }
        });

        lnr_ambulance.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dial(dial_ambulance);
                return false;
            }
        });

        lnr_immigration.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dial(dial_immigration);
                return false;
            }
        });

        lnr_hospital.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dial(dial_hospital);
                return false;
            }
        });

        imbHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome(view);
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

    public void goToHome(View view) {
        onBackPressed();
    }
}
