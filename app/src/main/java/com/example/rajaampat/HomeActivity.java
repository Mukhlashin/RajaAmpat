package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity {

    RelativeLayout rlvHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rlvHotel = findViewById(R.id.rlv_hotel);

        rlvHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHotel = new Intent(HomeActivity.this, HotelActivity.class);
                startActivity(goToHotel);
            }
        });

    }
}

