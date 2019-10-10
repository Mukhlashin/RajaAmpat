package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class DetailDestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_destination);

        ViewPager viewPager = findViewById(R.id.vpg_detail_destination);
        ImageDetailActivityAdapter adapter = new ImageDetailActivityAdapter(this);
        viewPager.setAdapter(adapter);

    }
}
