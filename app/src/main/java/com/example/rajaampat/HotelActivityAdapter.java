package com.example.rajaampat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajaampat.model.HotelDataItem;
import com.squareup.picasso.Picasso;

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
    public void onBindViewHolder(@NonNull HotelActivityAdapter.HotelActivityViewHolder holder, int position) {
        holder.nama.setText(list.get(position).getNamaHotel());
        holder.alamat.setText(list.get(position).getAlamatHotel());
        holder.harga.setText(list.get(position).getHargaKamar());
        Picasso.get()
                .load(list.get(position).getPicture())
                .into(holder.img);
//        holder.img.setImageResource(Integer.parseInt(list.get(position).getPicture()));
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
            alamat = itemView.findViewById(R.id.tv_alamatHotel);
            harga = itemView.findViewById(R.id.tv_hargaKamar);
            img = itemView.findViewById(R.id.img_hotel);
        }
    }
}
