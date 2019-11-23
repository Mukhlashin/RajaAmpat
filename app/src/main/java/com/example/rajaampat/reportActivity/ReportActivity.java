package com.example.rajaampat.reportActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rajaampat.ContactActivity;
import com.example.rajaampat.R;
import com.example.rajaampat.model.modelReport.ReportDataItem;
import com.example.rajaampat.model.modelReport.ResponseReport;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivity extends AppCompatActivity {

    ImageButton btnContact, btnAdd;
    ImageView imgReport;
    RecyclerView rvReport;
    ProgressDialog loading;
    ReportActivityAdapter adapter;
    List<ReportDataItem> data;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        loading = new ProgressDialog(ReportActivity.this);
        loading.setMessage("Loading....");
        loading.setCancelable(false);
        loading.show();

        mApiService = UtilsApi.getAPIService();

        btnContact = findViewById(R.id.btn_contact);
        btnAdd = findViewById(R.id.btn_add_report);
        imgReport = findViewById(R.id.img_report);
        rvReport = findViewById(R.id.rv_report);
        rvReport.setAdapter(adapter);
        getDataReport();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSendReportActivity();
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToContact();
            }

            private void goToContact() {
                Intent goToContact = new Intent(ReportActivity.this,  ContactActivity.class);
                startActivity(goToContact);
            }
        });
    }

    private void goToSendReportActivity() {
        Intent goToSendReport = new Intent(ReportActivity.this, SendReportActivity.class);
        startActivity(goToSendReport);
    }

    private void getDataReport() {
        mApiService.reportRequest()
                .enqueue(new Callback<ResponseReport>() {
                    @Override
                    public void onResponse(Call<ResponseReport> call, Response<ResponseReport> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            if(data!=null){
                                adapter = new ReportActivityAdapter(ReportActivity.this, data);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ReportActivity.this);
                                linearLayoutManager.setReverseLayout(true);
                                linearLayoutManager.setStackFromEnd(true);
                                rvReport.setLayoutManager(linearLayoutManager);
                                rvReport.setAdapter(adapter);
//                                rvReport.setLayoutManager(new LinearLayoutManager(ReportActivity.this));
//                                rvReport.setAdapter(adapter);
                            }else {
                                Toast.makeText(ReportActivity.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
                            }
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseReport> call, Throwable t) {
                        Log.d("onFailure", t.getLocalizedMessage());
                        loading.dismiss();
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        rvReport.setAdapter(null);
        getDataReport();
    }

    public void back(View view) {
        super.onBackPressed();
    }
}
