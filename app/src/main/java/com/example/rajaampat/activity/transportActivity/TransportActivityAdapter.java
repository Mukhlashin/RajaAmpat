package com.example.rajaampat.activity.transportActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajaampat.R;
import com.example.rajaampat.activity.contactActivity.ContactActivityAdapter;
import com.example.rajaampat.model.modelContact.ContactDataItem;
import com.example.rajaampat.model.modelTransport.TransportDataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TransportActivityAdapter extends RecyclerView.Adapter<TransportActivityAdapter.TransportActivityViewHolder> {

    private List<TransportDataItem> list;
    private Context context;

    public TransportActivityAdapter(Context context, List<TransportDataItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TransportActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemview_transport_activity, null);
        return new TransportActivityAdapter.TransportActivityViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull TransportActivityViewHolder holder, int position) {
        Picasso.get().load(list.get(position).getPicture()).into(holder.imgTransport);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TransportActivityViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTransport;
        public TransportActivityViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            imgTransport = itemView.findViewById(R.id.img_transport);
        }
    }
}
