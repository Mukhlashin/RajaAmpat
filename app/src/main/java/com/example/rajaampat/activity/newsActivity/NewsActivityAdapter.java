package com.example.rajaampat.activity.newsActivity;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajaampat.R;
import com.example.rajaampat.model.modelNews.NewsDataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsActivityAdapter extends RecyclerView.Adapter<NewsActivityAdapter.NewsActivityViewHolder> {

    private List<NewsDataItem> list;
    private Context context;

    public NewsActivityAdapter(Context context, List<NewsDataItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewsActivityAdapter.NewsActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemview_activity_news, null);
        return new NewsActivityViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsActivityAdapter.NewsActivityViewHolder holder, final int position) {
        holder.info.setText(Html.fromHtml(list.get(position).getDetilArtikel()));
        holder.judul.setText(Html.fromHtml(list.get(position).getJudulArtikel()));
        Picasso.get().load(list.get(position).getPicture()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentData = new Intent(context, DetailNewsActivity.class);
                intentData.putExtra("detailArtikel", list.get(position).getDetilArtikel());
                intentData.putExtra("judulArtikel", list.get(position).getJudulArtikel());
                intentData.putExtra("pictureArtikel", list.get(position).getPicture());
                context.startActivity(intentData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewsActivityViewHolder extends RecyclerView.ViewHolder {
        TextView judul, info;
        ImageView img;
        public NewsActivityViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            judul = itemView.findViewById(R.id.tv_judul_news);
            info = itemView.findViewById(R.id.tv_info_news);
            img = itemView.findViewById(R.id.img_news);
        }
    }
}
