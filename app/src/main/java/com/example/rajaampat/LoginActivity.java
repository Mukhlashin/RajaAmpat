package com.example.rajaampat;

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

import com.example.rajaampat.model.ResponseUser;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public EditText etEmail;
    public EditText etPassword;
    Button btnLogin;
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

                try {
                    Log.d("email ", email+ " pass " + pass
                            + " api_key " + apiKey);
                } catch (Exception e) {
                    Log.d("initComponents: ", e.getLocalizedMessage());
                }
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
                        if (response.body().getIsError().equals("false")){
                        loading.dismiss();
                        saveUser(responseUser, pass);
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        Toast.makeText(mContext, "Selamat datang " + responseUser.getUserName(), Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        Log.d("Prefs :", responseUser.getUserId());
                        Log.d("Prefs :", responseUser.getUserName());
                        Log.d("Prefs :", responseUser.getEmail());
                        Log.d("Prefs :", myPref.getString("pass", ""));
                        SharedPreferences.Editor editorSpLogin = getSharedPreferences("login", MODE_PRIVATE).edit();
                        editorSpLogin.putBoolean("login", true);
                        editorSpLogin.apply();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseUser> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getLocalizedMessage());
                        loading.dismiss();
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
}
