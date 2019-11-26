package com.example.rajaampat.activity.reportActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajaampat.R;
import com.squareup.picasso.Picasso;

public class DetailReportActivity extends AppCompatActivity {

    ImageView imgDetailReport;
    TextView tvJudulReport, tvPelaporReport, tvKeteranganReport, tvLokasiReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_report);

        imgDetailReport = findViewById(R.id.img_detail_report);

        tvJudulReport = findViewById(R.id.tv_judul_report_detail);
        tvPelaporReport = findViewById(R.id.tv_pelapor_detail);
        tvKeteranganReport = findViewById(R.id.tv_keterangan_report);
        tvLokasiReport = findViewById(R.id.tv_lokasi_report);

        Intent getIntent = getIntent();

        String judulReport = getIntent.getStringExtra("judulReport");
        String keteranganReport = getIntent.getStringExtra("keteranganReport");
        String pelaporReport = getIntent.getStringExtra("pelaporReport");
        String imgDetailReportFoto = getIntent.getStringExtra("pictureReport");
        String lokasiReport = getIntent.getStringExtra("lokasiReport");

        tvKeteranganReport.setText(keteranganReport);
        tvPelaporReport.setText("Pelapor : " + pelaporReport);
        tvJudulReport.setText(judulReport);
        tvLokasiReport.setText("Lokasi : " + lokasiReport);
        Picasso.get().load(imgDetailReportFoto).into(imgDetailReport);
    }

    public void back(View view) {
        super.onBackPressed();
    }
}
