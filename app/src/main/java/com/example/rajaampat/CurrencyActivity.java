package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class CurrencyActivity extends AppCompatActivity {

    ImageButton btnBack;
    Button btnConvert;
    SharedPreferences myPrefs;
    SharedPreferences.Editor editor;
    EditText edtUSD, edtIDR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        btnConvert = findViewById(R.id.btn_convert);
        btnBack = findViewById(R.id.btn_back);
        edtUSD = findViewById(R.id.edt_usd);
        edtIDR = findViewById(R.id.edt_idr);

        myPrefs = getSharedPreferences("currency", MODE_PRIVATE);
        editor = getSharedPreferences("currency", MODE_PRIVATE).edit();

        AndroidNetworking.post("https://www.freeforexapi.com/api/live")
                .addQueryParameter("pairs", "USDIDR")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response != null) {
                                String rate = response.getJSONObject("rates").getJSONObject("USDIDR").getString("rate");
                                String timeStamp = response.getJSONObject("rates").getJSONObject("USDIDR").getString("timestamp");
                                Log.d("responseRate", rate);
                                Log.d("responseTimestamp", timeStamp);
                                editor.putString("rate", rate);
                                editor.putString("timestamp", timeStamp);
                                editor.apply();
                            } else {
                                Log.d("error", "Respon gak dapat");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

        edtIDR.setText(myPrefs.getString("rate", ""));

        edtUSD.setText("1");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        int USD = Integer.parseInt(edtUSD.getText().toString());
        int rate = Integer.parseInt(myPrefs.getString("rate", ""));
            if (rate != 0) {
                edtIDR.setText("" + USD * rate);
                Toast.makeText(CurrencyActivity.this, "Timestamp = " + myPrefs.getString("timestamp", "Tidak dapat timestamp"), Toast.LENGTH_SHORT).show();
            }
        }
    }