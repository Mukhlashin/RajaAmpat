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
    Button ton1;
    EditText editNama, editKtp, editTtl, editAlamat, editKecamatan, editKelurahan;

    // Tombol Baligh
    ImageView baligh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        dbHelper = new DataHelper(this);
        editNama = (EditText) findViewById(R.id.edt_nama);
        editKtp = (EditText) findViewById(R.id.edt_ktp);
        editTtl = (EditText) findViewById(R.id.edt_ttl);
        editAlamat = (EditText) findViewById(R.id.edt_alamat);
        editKecamatan = (EditText) findViewById(R.id.edt_kecamatan);
        editKelurahan = (EditText) findViewById(R.id.edt_kelurahan);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodataprofil WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)

        {
            cursor.moveToPosition(0);
            editNama.setText(cursor.getString(0).toString());
            editKtp.setText(cursor.getString(1).toString());
            editTtl.setText(cursor.getString(2).toString());
            editAlamat.setText(cursor.getString(3).toString());
            editKecamatan.setText(cursor.getString(4).toString());
            editKelurahan.setText(cursor.getString(5).toString());
        }

        ton1 = (Button) findViewById(R.id.btn_simpanedit);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update biodataprofil set nama='"+
                        editNama.getText().toString() +"', ktp='" +
                        editKtp.getText().toString()+"', ttl='"+
                        editTtl.getText().toString() +"', alamat='" +
                        editAlamat.getText().toString() + "' kecamatan='" +
                        editKecamatan.getText().toString() + "' kelurahan='" +
                        editKelurahan.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil Neh :V", Toast.LENGTH_LONG).show();
                finish();
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