package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DetailDestinationActivity extends AppCompatActivity {

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_destination);

//        ViewPager viewPager = findViewById(R.id.vpg_detail_destination);
//        ImageDetailActivityAdapter adapter = new ImageDetailActivityAdapter(this);
//        viewPager.setAdapter(adapter);

        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToDestination = new Intent(DetailDestinationActivity.this, DestinationActivity.class);
                startActivity(goToDestination);
            }
        });

    }
}
