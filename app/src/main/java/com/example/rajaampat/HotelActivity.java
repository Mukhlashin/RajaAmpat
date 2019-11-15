package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.rajaampat.model.HotelDataItem;
import com.example.rajaampat.model.ResponseHotel;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelActivity extends AppCompatActivity {

    ImageButton btnBack;
    ProgressDialog loading;
    RecyclerView rvHotel;
    List<HotelDataItem> data;
    HotelActivityAdapter adapter;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        loading = new ProgressDialog(HotelActivity.this);
        loading.setMessage("Loading....");
        loading.show();

        mApiService = UtilsApi.getAPIService();
        btnBack = findViewById(R.id.btn_back);
        rvHotel = findViewById(R.id.rv_hotel);

        rvHotel.setAdapter(adapter);
        getDataHotel();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void getDataHotel() {
        mApiService.hotelRequest()
                .enqueue(new Callback<ResponseHotel>() {
                    @Override
                    public void onResponse(Call<ResponseHotel> call, Response<ResponseHotel> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            adapter = new HotelActivityAdapter(HotelActivity.this, data);
                            rvHotel.setLayoutManager(new LinearLayoutManager(HotelActivity.this));
                            rvHotel.setAdapter(adapter);
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseHotel> call, Throwable t) {
                        Log.d("onFailure", t.getLocalizedMessage());
                        loading.dismiss();
                    }
                });
    }
}