package com.example.rajaampat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.rajaampat.R;
import com.example.rajaampat.activity.logRegActivity.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    //Setting Dulu Durasi Splash Screennya...
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                startActivity(i); // Diubungin Dah...

                // Semua Sudah Asiap
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    }
}
