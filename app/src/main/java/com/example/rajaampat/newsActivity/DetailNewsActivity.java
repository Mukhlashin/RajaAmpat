package com.example.rajaampat.newsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajaampat.R;
import com.squareup.picasso.Picasso;

public class DetailNewsActivity extends AppCompatActivity {

    ImageButton btnBack;
    ImageView imgDetailNews;
    TextView tvJudulNews, tvDetailNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        btnBack = findViewById(R.id.btn_back);
        tvDetailNews = findViewById(R.id.tv_detail_news);
        tvJudulNews = findViewById(R.id.tv_judul_detail_news);
        imgDetailNews = findViewById(R.id.img_detail_news);

        Intent getIntent = getIntent();

        String judulNews = getIntent.getExtras().getString("judulArtikel");
        String detailNews = getIntent.getExtras().getString("detailArtikel");
        String pictureNews = getIntent.getExtras().getString("pictureArtikel");

        tvJudulNews.setText(judulNews);
        tvDetailNews.setText(detailNews);
        Picasso.get().load(pictureNews).into(imgDetailNews);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNews = new Intent(DetailNewsActivity.this, NewsActivity.class);
                startActivity(goToNews);
            }
        });

    }
}
