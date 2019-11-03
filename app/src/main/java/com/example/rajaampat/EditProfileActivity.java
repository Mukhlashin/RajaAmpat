package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    Button saveButton;
    EditText editNama, editKtp, editAlamat, editKecamatan, editKelurahan, editTempat, editTanggal;

    // Tombol Baligh
    ImageView baligh;

    SharedPreferences myPrefs;
    SharedPreferences myPrefs2;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        myPrefs = getSharedPreferences("userInfo", MODE_PRIVATE);
        editor = getSharedPreferences("userInfo", MODE_PRIVATE).edit();
        myPrefs2 = getSharedPreferences("com.example.rajaampat_example", MODE_PRIVATE);
        editor2 = getSharedPreferences("com.example.rajaampat_example", MODE_PRIVATE).edit();

        saveButton = findViewById(R.id.btn_simpanedit);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                saveDataUser();
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

    private void saveDataUser() {
//        editNama.setText(myPrefs);
    }

    @Override
    public void onBackPressed() {
        Intent backToProfile = new Intent(EditProfileActivity.this, HomeActivity.class);
        startActivity(backToProfile);
        finish();
    }
}