package com.example.rajaampat.hotelActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajaampat.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class DetailHotelActivity extends AppCompatActivity {

    ImageView imgDetailHotel;
    TextView tvNamaHotel, tvHargaKamar, tvTeleponHotel, tvEmailHotel, tvAlamatHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        tvNamaHotel = findViewById(R.id.tv_nama_hotel);
        tvHargaKamar = findViewById(R.id.tv_harga_kamar);
        tvTeleponHotel = findViewById(R.id.tv_telp_hotel);
        tvEmailHotel = findViewById(R.id.tv_email_hotel);
        tvAlamatHotel = findViewById(R.id.tv_alamat_hotel);
        imgDetailHotel = findViewById(R.id.img_detail_hotel);

        Intent getIntent = getIntent();

        String namaHotel = getIntent.getExtras().getString("namaHotel");
        String alamatHotel = getIntent.getExtras().getString("alamatHotel");
        String telpHotel = getIntent.getExtras().getString("telpHotel");
        String emailHotel = getIntent.getExtras().getString("emailHotel");
        String pictureHotel = getIntent.getExtras().getString("pictureHotel");
        String hargaKamar = getIntent.getExtras().getString("hargaHotel");

        DecimalFormat decim = new DecimalFormat("#,###.##");
        String decimHarga = decim.format(Double.valueOf(hargaKamar));
        tvNamaHotel.setText(Html.fromHtml(namaHotel));
        tvAlamatHotel.setText("Address : " + Html.fromHtml(alamatHotel));
        tvTeleponHotel.setText("Telephone : " + Html.fromHtml(telpHotel));
        tvEmailHotel.setText("Email : " + Html.fromHtml(emailHotel));
        tvHargaKamar.setText("Rp." + decimHarga);
        Picasso.get()
                .load(pictureHotel)
                .into(imgDetailHotel);

    }

    public void back(View view) {
        super.onBackPressed();
    }
}
