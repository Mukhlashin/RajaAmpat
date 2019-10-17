package com.example.rajaampat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "biodataprofil.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table biodataprofil (nama text null, ktp text null, ttl text null, alamat text null, kecamatan text null, kelurahan text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodataprofil (nama, ktp, ttl, alamat, kecamatan, kelurahan) VALUES ('Narto Syaifulden', '120312323232323939213', 'Depok Timur, Jawa Barat, Indonesia, Senin, 19 Oktober 1987','Jalan Swadaya Timur No. 7', 'Raja Ampat', 'Raja Ampat');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}