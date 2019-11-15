package com.example.rajaampat.reportActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajaampat.R;
import com.squareup.picasso.Picasso;

public class DetailReportActivity extends AppCompatActivity {

    ImageButton btnBack;
    ImageView imgDetailReport;
    TextView tvJudulReport, tvPelaporReport, tvKeteranganReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_report);

        imgDetailReport = findViewById(R.id.img_detail_report);

        tvJudulReport = findViewById(R.id.tv_judul_report_detail);
        tvPelaporReport = findViewById(R.id.tv_pelapor_detail);
        tvKeteranganReport = findViewById(R.id.tv_keterangan_report);

        btnBack = findViewById(R.id.btn_back);

        Intent getIntent = getIntent();

        String judulReport = getIntent.getStringExtra("judulReport");
        String keteranganReport = getIntent.getStringExtra("keteranganReport");
        String pelaporReport = getIntent.getStringExtra("pelaporReport");
        String imgDetailReportFoto = getIntent.getStringExtra("pictureReport");

        tvKeteranganReport.setText(keteranganReport);
        tvPelaporReport.setText("Pelapor : " + pelaporReport);
        tvJudulReport.setText(judulReport);
        Picasso.get().load(imgDetailReportFoto).into(imgDetailReport);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToReport = new Intent(DetailReportActivity.this, ReportActivity.class);
                startActivity(goToReport);
            }
        });

    }
}
