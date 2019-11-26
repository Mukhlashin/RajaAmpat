package com.example.rajaampat.activity.logRegActivity;

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

import com.example.rajaampat.R;
import com.example.rajaampat.model.modelUser.ResponseUser;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etNama, etEmail, etPassword;
    Button btnRegister;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;

    String defaultTglLahir = "00/00/0000";

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
                    etPassword.getText().toString(),
                    defaultTglLahir)
                    .enqueue(new Callback<ResponseUser>() {
                        @Override
                        public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                            if (response.isSuccessful()){
                                Log.i("debug", "onResponse: BERHASIL");
                                Toast.makeText(mContext, "Berhasil Register Akun", Toast.LENGTH_SHORT).show();
                                loading.dismiss();
                                goToLogin();
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

    private void goToLogin() {
        Intent goToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(goToLogin);
    }
}
