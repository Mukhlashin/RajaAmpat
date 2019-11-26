package com.example.rajaampat.activity.hotelActivity;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajaampat.R;
import com.example.rajaampat.model.modelHotel.HotelDataItem;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class HotelActivityAdapter extends RecyclerView.Adapter<HotelActivityAdapter.HotelActivityViewHolder> {

    private List<HotelDataItem> list;
    private Context context;

    public HotelActivityAdapter(Context context, List<HotelDataItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HotelActivityAdapter.HotelActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemview_hotel_activity, null);
        return new HotelActivityViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelActivityAdapter.HotelActivityViewHolder holder, final int position) {
        DecimalFormat decim = new DecimalFormat("#,###.##");
        String decimHarga = decim.format(Double.valueOf(list.get(position).getHargaKamar()));
        holder.nama.setText(Html.fromHtml(list.get(position).getNamaHotel()));
        holder.alamat.setText(Html.fromHtml(list.get(position).getAlamatHotel()));
        holder.harga.setText("Rp." + decimHarga);
        Picasso.get()
                .load(list.get(position).getPicture())
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentData = new Intent(context, DetailHotelActivity.class);
                intentData.putExtra("namaHotel", list.get(position).getNamaHotel());
                intentData.putExtra("alamatHotel", list.get(position).getAlamatHotel());
                intentData.putExtra("hargaHotel", list.get(position).getHargaKamar());
                intentData.putExtra("emailHotel", list.get(position).getEmailHotel());
                intentData.putExtra("telpHotel", list.get(position).getNoTlp());
                intentData.putExtra("pictureHotel", list.get(position).getPicture());
                context.startActivity(intentData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HotelActivityViewHolder extends RecyclerView.ViewHolder {
        TextView nama, alamat, harga;
        ImageView img;
        public HotelActivityViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            nama = itemView.findViewById(R.id.tv_namaHotel);
            alamat = itemView.findViewById(R.id.tv_alamat_hotel);
            harga = itemView.findViewById(R.id.tv_hargaKamar);
            img = itemView.findViewById(R.id.img_hotel);
        }
    }
}