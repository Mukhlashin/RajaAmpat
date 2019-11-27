package com.example.rajaampat.activity.reportActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajaampat.R;
import com.squareup.picasso.Picasso;

public class DetailReportActivity extends AppCompatActivity {

    ImageView imgDetailReport;
    TextView tvJudulReport, tvPelaporReport, tvKeteranganReport, tvLokasiReport, tvResponAdmin, tvStatusReport;
    Button btnStatusReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_report);

        imgDetailReport = findViewById(R.id.img_detail_report);

        tvJudulReport = findViewById(R.id.tv_judul_report_detail);
        tvPelaporReport = findViewById(R.id.tv_pelapor_detail);
        tvKeteranganReport = findViewById(R.id.tv_keterangan_report);
        tvLokasiReport = findViewById(R.id.tv_lokasi_report);
        btnStatusReport = findViewById(R.id.btn_status);
        tvResponAdmin = findViewById(R.id.tv_respon_admin);
        tvStatusReport = findViewById(R.id.tv_status_report);

        Intent getIntent = getIntent();

        String judulReport = getIntent.getStringExtra("judulReport");
        String keteranganReport = getIntent.getStringExtra("keteranganReport");
        String pelaporReport = getIntent.getStringExtra("pelaporReport");
        String imgDetailReportFoto = getIntent.getStringExtra("pictureReport");
        String lokasiReport = getIntent.getStringExtra("lokasiReport");
        String statusReport = getIntent.getStringExtra("statusReport");
        String responAdmin = getIntent.getStringExtra("responAdmin");

        if(statusReport.equals("1")){
            tvStatusReport.setText("Open");
            btnStatusReport.setBackground(getResources().getDrawable(R.drawable.circle_back1));
        }else if(statusReport.equals("2")){
            tvStatusReport.setText("Process");
            btnStatusReport.setBackground(getResources().getDrawable(R.drawable.circle_back2));
        }else if(statusReport.equals("3")){
            tvStatusReport.setText("Closed");
            btnStatusReport.setBackground(getResources().getDrawable(R.drawable.circle_back3));
        }

        if (responAdmin != null){
            tvResponAdmin.setText(responAdmin);
        } else {
            tvResponAdmin.setText("Belum ada respon dari Admin");
        }

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
