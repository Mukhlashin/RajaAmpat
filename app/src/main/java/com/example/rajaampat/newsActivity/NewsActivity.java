package com.example.rajaampat.newsActivity;

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

import com.example.rajaampat.DestinationActivity;
import com.example.rajaampat.DestinationActivityAdapter;
import com.example.rajaampat.HomeActivity;
import com.example.rajaampat.R;
import com.example.rajaampat.model.NewsDataItem;
import com.example.rajaampat.model.ResponseNews;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

public class NewsActivity extends AppCompatActivity {

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
        loading.setCancelable(false);
        loading.show();

        mApiService = UtilsApi.getAPIService();

        rvNews = findViewById(R.id.rv_news);

        rvNews.setAdapter(adapter);
        getDataNews();

    }

    private void getDataNews() {
        mApiService.newsRequest()
                .enqueue(new Callback<ResponseNews>() {
                    @Override
                    public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            adapter = new NewsActivityAdapter(NewsActivity.this, data);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NewsActivity.this);
                            linearLayoutManager.setReverseLayout(true);
                            linearLayoutManager.setStackFromEnd(true);
                            rvNews.setLayoutManager(linearLayoutManager);
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

    public void back(View view) {
        super.onBackPressed();
    }


//    private void generateData (List<News>list){
//        rvNews = findViewById(R.id.rv_news);
//         newsAdapter = new NewsActivityAdapter(this,list);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NewsActivity.this);
//        rvNews.setLayoutManager(layoutManager);
//        rvNews.setAdapter(newsAdapter);
//    }
}
