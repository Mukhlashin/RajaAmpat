package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.rajaampat.model.News;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.RetrofitClient;

import java.util.List;

public class NewsActivity extends AppCompatActivity {

    ImageButton btnBack;
    RecyclerView rvNews;
    RecyclerView.Adapter newsAdapter;
    RecyclerView.LayoutManager mgNews;
    ProgressDialog progressDoalog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        progressDoalog = new ProgressDialog(NewsActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        btnBack = findViewById(R.id.btn_back);
        rvNews = findViewById(R.id.rv_news);




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

    private void generateData (List<News>list){
        rvNews = findViewById(R.id.rv_news);
         newsAdapter = new NewsActivityAdapter(this,list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NewsActivity.this);
        rvNews.setLayoutManager(layoutManager);
        rvNews.setAdapter(newsAdapter);
    }
}
