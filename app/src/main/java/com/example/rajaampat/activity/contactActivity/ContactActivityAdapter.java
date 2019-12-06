package com.example.rajaampat.activity.contactActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajaampat.R;
import com.example.rajaampat.activity.newsActivity.DetailNewsActivity;
import com.example.rajaampat.activity.newsActivity.NewsActivityAdapter;
import com.example.rajaampat.model.modelContact.ContactDataItem;
import com.example.rajaampat.model.modelNews.NewsDataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactActivityAdapter extends RecyclerView.Adapter<ContactActivityAdapter.ContactActivityViewHolder> {

    private List<ContactDataItem> list;
    private Context context;

    public ContactActivityAdapter(Context context, List<ContactDataItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ContactActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemview_contact_activity, null);
        return new ContactActivityAdapter.ContactActivityViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactActivityViewHolder holder, final int position) {
        holder.tvNamaInstansi.setText(Html.fromHtml(list.get(position).getNamaInstansi()));
        holder.tvNomorInstansi.setText(Html.fromHtml(list.get(position).getNomorInstansi()));
        Picasso.get().load(list.get(position).getLogo()).into(holder.imgIconInstansi);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + Html.fromHtml(list.get(position).getNomorInstansi())));
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ContactActivityViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaInstansi, tvNomorInstansi;
        ImageView imgIconInstansi;
        public ContactActivityViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            tvNamaInstansi = itemView.findViewById(R.id.tv_instance_name);
            tvNomorInstansi = itemView.findViewById(R.id.tv_instance_number);
            imgIconInstansi= itemView.findViewById(R.id.img_logo_instance);
        }
    }
}
