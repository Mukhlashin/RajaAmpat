package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rajaampat.forLogin.BaseApiService;
import com.example.rajaampat.forLogin.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponents();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestLogin();
            }
                private void requestLogin(){
                    mApiService.loginRequest(etEmail.getText().toString(), etPassword.getText().toString())
                            .enqueue(new Callback<ResponseBody>() {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                    if (response.isSuccessful()){
                                        loading.dismiss();
                                        try {
                                            JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                            if (jsonRESULTS.getString("error").equals("false")){
                                                // Jika login berhasil maka data nama yang ada di response API
                                                // akan diparsing ke activity selanjutnya.
                                                Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                                String nama = jsonRESULTS.getJSONObject("user").getString("nama");
                                                Intent intent = new Intent(mContext, HotelActivity.class);
                                                intent.putExtra("result_nama", nama);
                                                startActivity(intent);
                                            } else {
                                                // Jika login gagal
                                                String error_message = jsonRESULTS.getString("error_msg");
                                                Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        loading.dismiss();
                                    }
                                }

                                @Override
                                public void onFailure(Call<ResponseBody> call, Throwable t) {
                                    Log.e("debug", "onFailure: ERROR > " + t.toString());
                                    loading.dismiss();
                                }
                            });
                }
            });
        }

    private void initComponents() {
        etEmail = (EditText) findViewById(R.id.edt_emailnye);
        etPassword = (EditText) findViewById(R.id.edt_passwordnye);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }

    public void goToRegister(View view) {
        Intent goToRegister = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(goToRegister);
    }
}
