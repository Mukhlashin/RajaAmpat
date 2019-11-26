package com.example.rajaampat.activity.contactActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rajaampat.R;
import com.example.rajaampat.activity.newsActivity.NewsActivity;
import com.example.rajaampat.activity.newsActivity.NewsActivityAdapter;
import com.example.rajaampat.model.modelContact.ContactDataItem;
import com.example.rajaampat.model.modelContact.ResponseContact;
import com.example.rajaampat.model.modelNews.NewsDataItem;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactActivity extends AppCompatActivity {

    RecyclerView rvContact;
    ContactActivityAdapter adapter;
    List<ContactDataItem> data;
    ProgressDialog loading;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        rvContact = findViewById(R.id.rv_contact);

        loading = new ProgressDialog(ContactActivity.this);
        loading.setMessage("Getting latest emergency data service...");
        loading.setCancelable(false);
        loading.show();

        mApiService = UtilsApi.getAPIService();

        rvContact.setAdapter(adapter);
        getDataContact();

//    public void back(View view) {
//        super.onBackPressed();
//    }
    }

    private void getDataContact() {
        mApiService.contactRequest()
                .enqueue(new Callback<ResponseContact>() {
                    @Override
                    public void onResponse(Call<ResponseContact> call, Response<ResponseContact> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            adapter = new ContactActivityAdapter(ContactActivity.this, data);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ContactActivity.this);
                            rvContact.setLayoutManager(linearLayoutManager);
                            rvContact.setAdapter(adapter);
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseContact> call, Throwable t) {
                        try {
                            Log.d("onError : ", t.getLocalizedMessage());
                            Toast.makeText(ContactActivity.this, "There's a Problem", Toast.LENGTH_SHORT).show();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        loading.dismiss();
                    }
                });
    }

    public void back(View view) {
        super.onBackPressed();
    }
}
