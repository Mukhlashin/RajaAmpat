package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyActivity extends AppCompatActivity {
    EditText input_usd;
    Button hasil_konversi;
    TextView output_idr;

    double nilai;

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        input_usd = (EditText) findViewById(R.id.uang_usd);
        output_idr = (TextView) findViewById(R.id.uang_idr);
        hasil_konversi = (Button) findViewById(R.id.btn_konversi);

        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public boolean cek(){
        if (input_usd.getText().toString().isEmpty()){
            Toast.makeText(this, "Silahkan Masukan Jumlah Uangnya", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void toUSD(View v){
        if (!cek()){
            return;
        }

        try{
            nilai = Double.parseDouble(input_usd.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "Masukkan Angkanya", Toast.LENGTH_SHORT).show();
        }

        output_idr.setText(Double.toString(nilai * 12000));
        Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show();
    }
}

