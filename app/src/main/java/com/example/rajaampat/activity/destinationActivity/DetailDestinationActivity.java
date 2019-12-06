package com.example.rajaampat.activity.destinationActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rajaampat.R;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class DetailDestinationActivity extends AppCompatActivity {

    TextView tvJudulDestination, tvDetailDestination;
    ViewPager vpgTravelDetail;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_destination);

        tvDetailDestination = findViewById(R.id.tv_detail_travel);
        tvJudulDestination = findViewById(R.id.tv_judul_detail_travel);
        vpgTravelDetail = findViewById(R.id.vpg_detail_travel);
        tabLayout = findViewById(R.id.tab_layout);

        Intent getIntent = getIntent();

        String judulTravel = getIntent.getExtras().getString("nama_tujuan_wisata");
        String detailTravel = getIntent.getExtras().getString("deskripsi");
        String[] picture = getIntent.getStringArrayExtra("picture");

        ViewPagerAdapter adapter = new ViewPagerAdapter(getApplicationContext(), picture);

        if (picture == null || picture.equals("")){
            Toast.makeText(this, "Image tidak ditemukan", Toast.LENGTH_SHORT).show();
            vpgTravelDetail.setBackgroundResource(R.drawable.no_image);
        } else {
            vpgTravelDetail.setAdapter(adapter);
            tabLayout.setupWithViewPager(vpgTravelDetail, true);
        }

        tvJudulDestination.setText(Html.fromHtml(judulTravel));
        tvDetailDestination.setText(Html.fromHtml(detailTravel));
    }

    public void back(View view) {
        super.onBackPressed();
    }
}
