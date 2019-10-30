package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button saveButton;
    EditText editNama, editKtp, editAlamat, editKecamatan, editKelurahan, editTempat, editTanggal;

    // Tombol Baligh
    ImageView baligh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        saveButton = findViewById(R.id.btn_simpanedit);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

            }
        });

        // Buat Fungsi Tombol Baligh Di Toolbar
        baligh = findViewById(R.id.kembali_editprofile);
        baligh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent backToProfile = new Intent(EditProfileActivity.this, HomeActivity.class);
        startActivity(backToProfile);
        finish();
    }
}