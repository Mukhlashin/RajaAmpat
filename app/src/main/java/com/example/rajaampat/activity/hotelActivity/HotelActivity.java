package com.example.rajaampat.activity.hotelActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.rajaampat.R;
import com.example.rajaampat.model.modelHotel.HotelDataItem;
import com.example.rajaampat.model.modelHotel.ResponseHotel;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelActivity extends AppCompatActivity {

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
        loading.setCancelable(false);
        loading.show();

        mApiService = UtilsApi.getAPIService();
        rvHotel = findViewById(R.id.rv_hotel);

        rvHotel.setAdapter(adapter);
        getDataHotel();
    }

    private void getDataHotel() {
        mApiService.hotelRequest()
                .enqueue(new Callback<ResponseHotel>() {
                    @Override
                    public void onResponse(Call<ResponseHotel> call, Response<ResponseHotel> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            adapter = new HotelActivityAdapter(HotelActivity.this, data);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HotelActivity.this);
                            linearLayoutManager.setReverseLayout(true);
                            linearLayoutManager.setStackFromEnd(true);
                            rvHotel.setLayoutManager(linearLayoutManager);
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

    public void back(View view) {
        super.onBackPressed();
    }

}