package com.example.rajaampat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.rajaampat.model.DataItem;
import com.example.rajaampat.model.ResponseSingleUser;
import com.example.rajaampat.model.ResponseUser;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    Button btnReport, btnTravel, btnNews, btnHotel, btnEmergency, btnCurrency, btnTransport;
    ImageButton imbSetting;

    SharedPreferences.Editor editor;
    SharedPreferences myPref;

    public List<DataItem> dataItems;

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

        mApiService = UtilsApi.getAPIService();

        myPref = getSharedPreferences("com.example.rajaampat_preferences", MODE_PRIVATE);

        imbSetting = findViewById(R.id.imb_settings);

        userId = myPref.getString("id", "");

        Log.d("dapat id nya", myPref.getString("id", "gak dapat"));

        editor = getSharedPreferences("userInfo", MODE_PRIVATE).edit();

        singleUserInquiry();

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

    private void singleUserInquiry() {
        mApiService.singleUserRequest(userId)
                .enqueue(new Callback<ResponseSingleUser>() {
                    @Override
                    public void onResponse(Call<ResponseSingleUser> call, Response<ResponseSingleUser> response) {
                        if (response.code() == 503) {
                            Toast.makeText(context, "Gagal menyambungkan ke server, Hanya menampilkan data lokal", Toast.LENGTH_SHORT).show();
                        } else {
                            ResponseSingleUser responseSingleUser = response.body();
                            dataItems = responseSingleUser.getData();
                            editor.putString("user_name", dataItems.get(0).getNama());
                            editor.putString("alamat", dataItems.get(0).getAlamat());
                            editor.putString("no_tlp", dataItems.get(0).getNoTlp());
                            editor.putString("no_ktp", dataItems.get(0).getNoKtp());
                            editor.putString("tempat_lahir", dataItems.get(0).getTempatLahir());
                            editor.putString("tanggal_lahir", dataItems.get(0).getTglLahir());
                            editor.apply();
                        }
//                        ooooooohhh. gttuu toh
//
//                                ini lho yang dari tadi saya cari oawkoaw...ntar  coba dulu
//                        dah coba dulu
//                                okok
//                        jadi yang diambil nanti ini dataItems nya? iya data itemnya kan belum ada datanya nah disini data itemnya disii dengan data  dari API nya
//                                Wadoo ini bukan ngisi data tapi ngambil data dari APi nya oawkawo
//                                mau di tampilin kan?
//                        iya ya udah udah bener kan nanti ambil datanya dari data item?
//                        iya bener iya
//                                adaptenta mana? gak pake adapter... sebenarnya ini fungsi buat manggil data dari api berdasarkan id yang saya simpan di shareprefs
//                                nah datanya udah masuk ni
//                                udh success... tapi bingungnya katanya null gtu
//                                ntar coba dulu ni

                        // hmm ntar
                    }

                    @Override
                    public void onFailure(Call<ResponseSingleUser> call, Throwable t) {
                        Toast.makeText(context, "onError : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

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

