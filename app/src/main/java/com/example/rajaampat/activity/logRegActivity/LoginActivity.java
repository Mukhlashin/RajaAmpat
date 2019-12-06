package com.example.rajaampat.activity.logRegActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rajaampat.R;
import com.example.rajaampat.activity.forgotPasswordActivity.ForgotPasswordActivity;
import com.example.rajaampat.activity.homeActivity.HomeActivity;
import com.example.rajaampat.model.modelUser.ResponseUser;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public EditText etEmail;
    public EditText etPassword;
    Button btnLogin, btnLetMeIn;
    ProgressDialog loading;

    //SharedPrefrences
    SharedPreferences myPref;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editorLogin;

    Context mContext;
    BaseApiService mApiService;

    //    TODO Taro di Gradle -fatih
    public String apiKey = "s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        etEmail = findViewById(R.id.edt_emailnye);
        etPassword = findViewById(R.id.edt_passwordnye);
        btnLogin = findViewById(R.id.btn_login);
        mApiService = UtilsApi.getAPIService();

        myPref = getSharedPreferences("userInfo", MODE_PRIVATE);
        editor = getSharedPreferences("userInfo", MODE_PRIVATE).edit();
        editorLogin = getSharedPreferences("login", MODE_PRIVATE).edit();

        SharedPreferences isLogin = getSharedPreferences("login", MODE_PRIVATE);
        if(isLogin.getBoolean("login", false)){
            goToMain();
        }

        initComponents();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestLogin(email,pass);
            }
        });
    }

    private void goToMain() {
        Intent goToMain = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(goToMain);
    }

    public void saveUser(ResponseUser user, String pass) {
        //        Initial object
        myPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editorLogin = myPref.edit();
        editorLogin.putString("id", user.getUserId());
        editorLogin.putString("user_name", user.getUserName());
        editorLogin.putString("email", user.getEmail());
        editorLogin.putString("pass", pass);
        editorLogin.apply();
    }

    private void requestLogin(String email, final String pass){
        mApiService.loginRequest(apiKey,email, pass)
                .enqueue(new Callback<ResponseUser>() {
                    @Override
                    public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                        ResponseUser responseUser = response.body();
                        if (response.isSuccessful()){
                        loading.dismiss();
                        saveUser(responseUser, pass);
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        Toast.makeText(mContext, "Selamat datang " + responseUser.getUserName(), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        SharedPreferences.Editor editorSpLogin = getSharedPreferences("login", MODE_PRIVATE).edit();
                        editorSpLogin.putBoolean("login", true);
                        editorSpLogin.apply();
                        } else {
                            Toast.makeText(mContext, "User or email not valid or not found" , Toast.LENGTH_SHORT).show();
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseUser> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getLocalizedMessage());
                        loading.dismiss();
                        LoginActivity.this.setContentView(R.layout.error_layout);
                        btnLetMeIn = findViewById(R.id.btn_let_me_in);
                        btnLetMeIn.setText("Kembali ke halaman Login");
                        btnLetMeIn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                LoginActivity.this.setContentView(R.layout.activity_login);
                            }
                        });
                    }
                });
    }

    private void initComponents() {
        etEmail = findViewById(R.id.edt_emailnye);
        etPassword = findViewById(R.id.edt_passwordnye);
        btnLogin = findViewById(R.id.btn_login);

    }

    public void goToRegister(View view) {
        Intent goToRegister = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(goToRegister);
    }

    public void goToForgotPassword(View view) {
        Intent goToForgotPassword = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(goToForgotPassword);
    }
}