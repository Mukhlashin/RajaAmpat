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

import com.example.rajaampat.R;
import com.squareup.picasso.Picasso;

public class DetailDestinationActivity extends AppCompatActivity {

    ImageView imgDetailDestination;
    TextView tvJudulDestination, tvDetailDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_destination);

        tvDetailDestination = findViewById(R.id.tv_detail_travel);
        tvJudulDestination = findViewById(R.id.tv_judul_detail_travel);
        imgDetailDestination = findViewById(R.id.img_detail_travel);

        Intent getIntent = getIntent();

        String judulTravel = getIntent.getExtras().getString("nama_tujuan_wisata");
        String detailTravel = getIntent.getExtras().getString("deskripsi");
        String pictureTravel = getIntent.getExtras().getString("picture");

        tvJudulDestination.setText(Html.fromHtml(judulTravel));
        tvDetailDestination.setText(Html.fromHtml(detailTravel));
        Picasso.get().load(pictureTravel).into(imgDetailDestination);
    }

    public void back(View view) {
        super.onBackPressed();
    }
}
