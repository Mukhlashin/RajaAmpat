package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ContactActivity extends AppCompatActivity {

    ImageButton imbHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        imbHome = findViewById(R.id.imb_home);

        imbHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome(view);
            }
        });

    }

    public void goToHome(View view) {
        Intent goToHome = new Intent(ContactActivity.this, HomeActivity.class);
        startActivity(goToHome);
    }
}
