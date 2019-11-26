package com.example.rajaampat.activity.currencyActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.rajaampat.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class CurrencyActivity extends AppCompatActivity {

    Button btnConvert;
    SharedPreferences myPrefs;
    SharedPreferences.Editor editor;
    EditText edtUSD;
    TextView tvIDR;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        loading = new ProgressDialog(CurrencyActivity.this);
        loading.setMessage("Getting latest currency rates....");
        loading.setCancelable(false);
        loading.show();

        btnConvert = findViewById(R.id.btn_convert);
        edtUSD = findViewById(R.id.edt_usd);
        tvIDR = findViewById(R.id.tv_idr);
        editor = getSharedPreferences("currency", MODE_PRIVATE).edit();
        myPrefs = getSharedPreferences("currency", MODE_PRIVATE);

        final DecimalFormat decim = new DecimalFormat("#,###.##");

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
                                loading.dismiss();
                                tvIDR.setText(decim.format(Double.valueOf(myPrefs.getString("rate", ""))));
                                edtUSD.setText("1");
                            } else {
                                Log.d("error", "Respon gak dapat");
                                Toast.makeText(CurrencyActivity.this, "Tidak mendapatkan respon dari Server", Toast.LENGTH_SHORT).show();
                                loading.dismiss();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(CurrencyActivity.this, "Failed to gate latest Exchange rate", Toast.LENGTH_SHORT).show();
                        loading.dismiss();
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

        if (myPrefs.getString("rate", "") != null || myPrefs.getString("timestamp", "") != null){
            DecimalFormat decim = new DecimalFormat("#,###.##");
            int USD = Integer.parseInt(edtUSD.getText().toString());
            Double rate = Double.parseDouble(myPrefs.getString("rate", ""));
            Double currency = USD * rate;
            String currency2 = currency.toString();
            if (rate != 0) {
                tvIDR.setText(decim.format(Double.valueOf(currency2)));
                Toast.makeText(CurrencyActivity.this, "Timestamp = " + myPrefs.getString("timestamp", "No Timestamp"), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please activate your Internet data to get Latest Exchange Rate from server", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        super.onBackPressed();
    }
}