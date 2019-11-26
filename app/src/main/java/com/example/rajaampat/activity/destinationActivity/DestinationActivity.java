package com.example.rajaampat.activity.destinationActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.rajaampat.R;
import com.example.rajaampat.model.modelReport.ResponseTravel;
import com.example.rajaampat.model.modelReport.TravelDataItem;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DestinationActivity extends AppCompatActivity {

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
        loading.setCancelable(false);
        loading.show();

        mApiService = UtilsApi.getAPIService();

        rvTravel = findViewById(R.id.rv_travel);

        rvTravel.setAdapter(adapter);
        getDataTravel();
    }

    private void getDataTravel() {
        mApiService.travelRequest()
                .enqueue(new Callback<ResponseTravel>() {
                    @Override
                    public void onResponse(Call<ResponseTravel> call, Response<ResponseTravel> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            adapter = new DestinationActivityAdapter(DestinationActivity.this, data);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DestinationActivity.this);
                            linearLayoutManager.setReverseLayout(true);
                            linearLayoutManager.setStackFromEnd(true);
                            rvTravel.setLayoutManager(linearLayoutManager);
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

        public void goToDetailDestination(View view) {
            Intent goToDestination = new Intent(DestinationActivity.this, DetailDestinationActivity.class);
            startActivity(goToDestination);
        }

    public void back(View view) {
        super.onBackPressed();
    }
}
