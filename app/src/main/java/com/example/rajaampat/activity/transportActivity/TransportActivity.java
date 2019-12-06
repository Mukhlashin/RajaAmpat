package com.example.rajaampat.activity.transportActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.rajaampat.R;
import com.example.rajaampat.activity.newsActivity.NewsActivity;
import com.example.rajaampat.activity.newsActivity.NewsActivityAdapter;
import com.example.rajaampat.model.modelNews.NewsDataItem;
import com.example.rajaampat.model.modelTransport.ResponseTransport;
import com.example.rajaampat.model.modelTransport.TransportDataItem;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransportActivity extends AppCompatActivity {

    RecyclerView rvTransport;
    TransportActivityAdapter adapter;
    List<TransportDataItem> data;
    ProgressDialog loading;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        rvTransport = findViewById(R.id.rv_transport);

        loading = new ProgressDialog(TransportActivity.this);
        loading.setMessage("Getting the latest Transport information from server....");
        loading.setCancelable(false);
        loading.show();

        mApiService = UtilsApi.getAPIService();

        rvTransport = findViewById(R.id.rv_transport);

        rvTransport.setAdapter(adapter);
        getDataTransport();

    }

    private void getDataTransport() {
        mApiService.transportRequest()
                .enqueue(new Callback<ResponseTransport>() {
                    @Override
                    public void onResponse(Call<ResponseTransport> call, Response<ResponseTransport> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            adapter = new TransportActivityAdapter(TransportActivity.this, data);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TransportActivity.this);
                            linearLayoutManager.setReverseLayout(true);
                            linearLayoutManager.setStackFromEnd(true);
                            rvTransport.setLayoutManager(linearLayoutManager);
                            rvTransport.setAdapter(adapter);
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseTransport> call, Throwable t) {
                        Toast.makeText(TransportActivity.this, "Mohon maaf untuk fitur ini masih dalam pengembangan", Toast.LENGTH_SHORT).show();
                        loading.dismiss();
                    }
                });
    }

    public void back(View view) {
        super.onBackPressed();
    }
}