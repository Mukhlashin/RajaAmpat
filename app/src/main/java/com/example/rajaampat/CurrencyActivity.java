package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.rajaampat.model.Rates;
import com.example.rajaampat.model.ResponseCurrency;
import com.example.rajaampat.network.BaseCurrencyService;
import com.example.rajaampat.network.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        edtUSD.setText("0");

        myPrefs = getSharedPreferences("currency", MODE_PRIVATE);
        editor = getSharedPreferences("currency", MODE_PRIVATE).edit();

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

        AndroidNetworking.post("https://www.freeforexapi.com/api/live")
                .addQueryParameter("pairs", "USDIDR")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {if (response != null){
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
    }

    private void convertCurrency() {
        try{
            int USD = Integer.parseInt(edtUSD.getText().toString());
            int rate = Integer.parseInt(myPrefs.getString("rates", ""));
            edtIDR.setText(rate * USD);
            Toast.makeText(CurrencyActivity.this, myPrefs.getString("timestamp", "Tidak dapat timestamp"), Toast.LENGTH_SHORT).show();
        } catch(NumberFormatException ex){ // handle your exception
            Log.d("onError", ex.getLocalizedMessage());
        }
    }
}
