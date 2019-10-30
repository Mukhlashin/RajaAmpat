package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rajaampat.LoginActivity;
import com.example.rajaampat.R;
import com.example.rajaampat.model.ResponseUser;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etNama;
    EditText etEmail;
    EditText etPassword;
    Button btnRegister;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;

    public String apiKey = "s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Loading
        Dialog loading = new Dialog(this);
        loading.setContentView(R.layout.loading_layout);
        loading.setCancelable(false);
        loading.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        initComponents();

    }

    private void initComponents() {
        etNama = findViewById(R.id.edt_user_name);
        etEmail = findViewById(R.id.edt_email);
        etPassword = findViewById(R.id.edt_password);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestRegister();
            }
        });
    }

        private void requestRegister(){
            mApiService.registerRequest(
                    apiKey,
                    etNama.getText().toString(),
                    etEmail.getText().toString(),
                    etPassword.getText().toString())
                    .enqueue(new Callback<ResponseUser>() {
                        @Override
                        public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                            if (response.isSuccessful()){
                                Log.i("debug", "onResponse: BERHASIL");
                                Toast.makeText(mContext, "Berhasil Register Akun", Toast.LENGTH_SHORT).show();
                                loading.dismiss();
                                goToHome();
                                try {
                                    JSONObject jsonRESULTS = new JSONObject(response.body().toString());
                                    if (jsonRESULTS.getString("is_error").equals("false")){
                                        Toast.makeText(mContext, "BERHASIL REGISTRASI", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(mContext, LoginActivity.class));
                                    } else {
                                        String error_message = jsonRESULTS.getString("error_msg");
                                        Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                Log.i("debug", "onResponse: GA BERHASIL");
                                Toast.makeText(mContext,  "Gagal Register Akun, Coba lagi", Toast.LENGTH_SHORT).show();
                                loading.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseUser> call, Throwable t) {
                            Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                            Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                        }
                    });
    }

    private void goToHome() {
        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
