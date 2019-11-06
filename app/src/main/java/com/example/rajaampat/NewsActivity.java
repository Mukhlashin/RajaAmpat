package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.rajaampat.model.DataItem;
import com.example.rajaampat.model.NewsDataItem;
import com.example.rajaampat.model.ResponseNews;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

public class NewsActivity extends AppCompatActivity {

    ImageButton btnBack;
    RecyclerView rvNews;
    RecyclerView.Adapter newsAdapter;
    RecyclerView.LayoutManager mgNews;
    NewsActivityAdapter adapter;
    List<NewsDataItem> data;
    ProgressDialog loading;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        loading = new ProgressDialog(NewsActivity.this);
        loading.setMessage("Loading....");
        loading.show();

        mApiService = UtilsApi.getAPIService();

        btnBack = findViewById(R.id.btn_back);
        rvNews = findViewById(R.id.rv_news);

        rvNews.setAdapter(adapter);
        getDataNews();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
    }

    private void getDataNews() {
        mApiService.NewsRequest()
                .enqueue(new Callback<ResponseNews>() {
                    @Override
                    public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            adapter = new NewsActivityAdapter(NewsActivity.this, data);
                            rvNews.setLayoutManager(new LinearLayoutManager(NewsActivity.this));
                            rvNews.setAdapter(adapter);
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseNews> call, Throwable t) {
                        Log.d("onFailure", t.getLocalizedMessage());
                        loading.dismiss();
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



//    private void generateData (List<News>list){
//        rvNews = findViewById(R.id.rv_news);
//         newsAdapter = new NewsActivityAdapter(this,list);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NewsActivity.this);
//        rvNews.setLayoutManager(layoutManager);
//        rvNews.setAdapter(newsAdapter);
//    }
}
