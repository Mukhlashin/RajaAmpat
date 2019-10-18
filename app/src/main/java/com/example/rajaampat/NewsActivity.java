package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class NewsActivity extends AppCompatActivity {

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
    }

    private void goToHome() {
        Intent goToHome = new Intent(NewsActivity.this, HomeActivity.class);
        startActivity(goToHome);
    }

    public void goToDetailNews(View view) {
        Intent goToDetaiNews = new Intent(NewsActivity.this, DetailNewsActivity.class);
        startActivity(goToDetaiNews);
    }
}
