package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailDestinationActivity extends AppCompatActivity {

    ImageButton btnBack;
    ImageView imgDetailDestination;
    TextView tvJudulDestination, tvDetailDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_destination);

        btnBack = findViewById(R.id.btn_back);
        tvDetailDestination = findViewById(R.id.tv_detail_travel);
        tvJudulDestination = findViewById(R.id.tv_judul_detail_travel);
        imgDetailDestination = findViewById(R.id.img_detail_travel);

        Intent getIntent = getIntent();

        String judulTravel = getIntent.getExtras().getString("nama_tujuan_wisata");
        String detailTravel = getIntent.getExtras().getString("deskripsi");
        String pictureTravel = getIntent.getExtras().getString("picture");

        tvJudulDestination.setText(judulTravel);
        tvDetailDestination.setText(detailTravel);
        Picasso.get().load(pictureTravel).into(imgDetailDestination);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNews = new Intent(DetailDestinationActivity.this, DestinationActivity.class);
                startActivity(goToNews);
            }
        });

    }
}
