package com.example.rajaampat.activity.forgotPasswordActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rajaampat.R;
import com.example.rajaampat.activity.logRegActivity.LoginActivity;
import com.example.rajaampat.activity.logRegActivity.RegisterActivity;
import com.example.rajaampat.model.modelForgotPassword.ForgotPasswordDataItem;
import com.example.rajaampat.model.modelForgotPassword.ResponseForgotPassword;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText edtEmail;
    Button btnSendLink;
    List<ForgotPasswordDataItem> data;
    BaseApiService mApiService;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mApiService = UtilsApi.getAPIService();

        edtEmail = findViewById(R.id.edt_email);
        btnSendLink = findViewById(R.id.btn_send_link);

        loading = new ProgressDialog(ForgotPasswordActivity.this);

        btnSendLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLink();
            }
        });
    }

    private void sendLink() {
        String email = edtEmail.getText().toString();
        if (edtEmail.getText() == null || edtEmail.getText().toString().equals("")){
            edtEmail.setError("Kolom email tidak boleh kosong");
        } else {
            loading.setMessage("Connecting to Server");
            loading.setCancelable(false);
            loading.show();
            mApiService.forgotPasswordRequest(email)
                    .enqueue(new Callback<ResponseForgotPassword>() {
                        @Override
                        public void onResponse(Call<ResponseForgotPassword> call, Response<ResponseForgotPassword> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(ForgotPasswordActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                                ForgotPasswordActivity.this.setContentView(R.layout.success_forgot_password);
                            } else {
                                Toast.makeText(ForgotPasswordActivity.this, "Gagal, mohon cek kembali email yang anda masukkan", Toast.LENGTH_SHORT).show();
                            }
                            loading.dismiss();
                        }

                        @Override
                        public void onFailure(Call<ResponseForgotPassword> call, Throwable t) {
                            Log.d("onError", t.getLocalizedMessage());
                            Toast.makeText(ForgotPasswordActivity.this, "Gagal, mohon cek kembali email yang anda masukkan", Toast.LENGTH_SHORT).show();
                            loading.dismiss();
                        }
                    });
        }
    }

    public void back(View view) {
        super.onBackPressed();
    }

    public void goToLogin(View view) {
        Intent goToLogin = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
        startActivity(goToLogin);
    }
}
