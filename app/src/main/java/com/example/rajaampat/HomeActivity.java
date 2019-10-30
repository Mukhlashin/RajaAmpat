package com.example.rajaampat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.Settings.Secure;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.example.rajaampat.model.ResponseUser;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    Button btnReport, btnTravel, btnNews, btnHotel, btnEmergency, btnCurrency, btnTransport;
    ImageButton imbSetting;

    SharedPreferences.Editor editor;
    SharedPreferences myPref;

    Context context;

    BaseApiService mApiService;

    String userId;

    public String apiKey = "s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnReport = findViewById(R.id.btn_report);
        btnHotel = findViewById(R.id.btn_hotel);
        btnNews = findViewById(R.id.btn_news);
        btnTravel = findViewById(R.id.btn_travel);
        btnCurrency = findViewById(R.id.btn_currency);
        btnTransport = findViewById(R.id.btn_transport);
        btnEmergency = findViewById(R.id.btn_emergency);

        myPref = getSharedPreferences("com.example.rajaampat_preferences", MODE_PRIVATE);

        imbSetting = findViewById(R.id.imb_settings);

//        userId = myPref.getString("id", "");

        Log.d("dapat id nya", myPref.getString("id", "gak dapat"));

        editor = getSharedPreferences("userInfo", MODE_PRIVATE).edit();

//        singleUserInquiry();

//        editor.putString("device_id", getDeviceUUID(context));

//        String android_id = Secure.getString(getContext().getContentResolver(),
//                Secure.ANDROID_ID);

//        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    Activity#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for Activity#requestPermissions for more details.
//            return;
//        }
//        telephonyManager.getDeviceId();

        imbSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MenuFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.real_container, fragment)
                        .addToBackStack("balik")
                        .commit();
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToReport = new Intent(HomeActivity.this, ReportActivity.class);
                startActivity(goToReport);
            }
        });

        btnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHotel = new Intent(HomeActivity.this, HotelActivity.class);
                startActivity(goToHotel);
            }
        });

        btnTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTravel = new Intent(HomeActivity.this, DestinationActivity.class);
                startActivity(goToTravel);
            }
        });

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNews = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(goToNews);
            }
        });

        btnCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCurrency = new Intent(HomeActivity.this, CurrencyActivity.class);
                startActivity(goToCurrency);
            }
        });

        btnEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToEmergency = new Intent(HomeActivity.this, ContactActivity.class);
                startActivity(goToEmergency);
            }
        });

        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTransport = new Intent(HomeActivity.this, TransportActivity.class);
                startActivity(goToTransport);
            }
        });
    }

//    private void singleUserInquiry() {
//        mApiService.singleUserRequest(apiKey, userId)
//                .enqueue(new Callback<ResponseUser>() {
//                    @Override
//                    public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
//                        ResponseUser responseUser = response.body();
//                        editor.putString("nama", responseUser.getNama());
//                        editor.putString("alamat", responseUser.getAlamat());
//                        editor.putString("no_tlp", responseUser.getNomorTelepon());
//                        editor.putString("no_ktp", responseUser.getNomorKTP());
//                        editor.putString("tempat_lahir", responseUser.getTempatLahir());
//                        editor.putString("tanggal_lahir", responseUser.getTanggalLahir());
//                        editor.apply();
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseUser> call, Throwable t) {
//                        Log.e("debug", "onFailure: ERROR > " + t.getLocalizedMessage());
//                    }
//                });
//    }

//    public static String getDeviceUUID(Context context) {
//        final TelephonyManager tm = (TelephonyManager) context
//                .getSystemService(Context.TELEPHONY_SERVICE);
//
//        final String tmDevice, tmSerial, androidId;
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return "";
//        }
//        tmDevice = "" + tm.getDeviceId();
//        tmSerial = "" + tm.getSimSerialNumber();
//        androidId = ""
//                + Settings.Secure.getString(context.getContentResolver(),
//                Settings.Secure.ANDROID_ID);
//
//        String deviceMobileNo = tm.getLine1Number();
//
//        UUID deviceUuid = new UUID(androidId.hashCode(),
//                ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
//        return deviceUuid.toString();
//
//    }

}

