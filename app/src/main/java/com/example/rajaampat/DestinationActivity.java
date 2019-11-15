package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.rajaampat.model.modelReport.ResponseTravel;
import com.example.rajaampat.model.modelReport.TravelDataItem;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DestinationActivity extends AppCompatActivity {

    ImageButton btnBack;
    RecyclerView rvTravel;
    RecyclerView.Adapter destinationAdapter;
    RecyclerView.LayoutManager mgDestination;
    DestinationActivityAdapter adapter;
    List<TravelDataItem> data;
    ProgressDialog loading;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        loading = new ProgressDialog(DestinationActivity.this);
        loading.setMessage("Loading....");
        loading.show();

        mApiService = UtilsApi.getAPIService();

        btnBack = findViewById(R.id.btn_back);
        rvTravel = findViewById(R.id.rv_travel);

        rvTravel.setAdapter(adapter);
        getDataTravel();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
    }

    private void getDataTravel() {
        mApiService.travelRequest()
                .enqueue(new Callback<ResponseTravel>() {
                    @Override
                    public void onResponse(Call<ResponseTravel> call, Response<ResponseTravel> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            adapter = new DestinationActivityAdapter(DestinationActivity.this, data);
                            rvTravel.setLayoutManager(new LinearLayoutManager(DestinationActivity.this));
                            rvTravel.setAdapter(adapter);
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseTravel> call, Throwable t) {
                        Log.d("onFailure", t.getLocalizedMessage());
                        loading.dismiss();
                    }
                });
    }

        private void goToHome() {
            Intent goToHome = new Intent(DestinationActivity.this, HomeActivity.class);
            startActivity(goToHome);
        }

        public void goToDetailDestination(View view) {
            Intent goToDestination = new Intent(DestinationActivity.this, DetailDestinationActivity.class);
            startActivity(goToDestination);
        }
}
