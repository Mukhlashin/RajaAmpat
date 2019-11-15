package com.example.rajaampat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajaampat.model.modelReport.TravelDataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DestinationActivityAdapter extends RecyclerView.Adapter<DestinationActivityAdapter.DestinationActivityViewHolder> {

    private List<TravelDataItem> list;
    private Context context;

    public DestinationActivityAdapter(Context context, List<TravelDataItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DestinationActivityAdapter.DestinationActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemview_destination_activity, null);
        return new DestinationActivityViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationActivityAdapter.DestinationActivityViewHolder holder, final int position) {
        holder.info.setText(list.get(position).getDeskripsi());
        holder.judul.setText(list.get(position).getNamaTujuanWisata());
        Picasso.get().load(list.get(position).getPicture()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentData = new Intent(context, DetailDestinationActivity.class);
                intentData.putExtra("deskripsi", list.get(position).getDeskripsi());
                intentData.putExtra("nama_tujuan_wisata", list.get(position).getNamaTujuanWisata());
                intentData.putExtra("picture", list.get(position).getPicture());
                context.startActivity(intentData);
            }
        });
//        holder.img.setImageResource(Integer.parseInt(list.get(position).getPicture()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DestinationActivityViewHolder extends RecyclerView.ViewHolder {
        TextView judul, info;
        ImageView img;
        public DestinationActivityViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            judul = itemView.findViewById(R.id.tv_judul_destination);
            info = itemView.findViewById(R.id.tv_info_destination);
            img = itemView.findViewById(R.id.img_destination);
        }
    }
}
