package com.example.rajaampat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rajaampat.model.News;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsActivityAdapter extends RecyclerView.Adapter<NewsActivityAdapter.NewsActivityViewHolder> {

    private List<News> list;
    private Context context;

    public NewsActivityAdapter(Context context, List<News> list) {
        this.context = context;
        this.list = list;
    }

    class NewsActivityViewHolder extends RecyclerView.ViewHolder {

        public View v;
        private ImageView pic;

        public NewsActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;

            pic= v.findViewById(R.id.img_destination);
        }
    }


    @NonNull
    @Override
    public NewsActivityAdapter.NewsActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.itemview_activity_news, parent, false);
        return new NewsActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsActivityAdapter.NewsActivityViewHolder holder, int position) {
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(list.get(position).getPicture())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.pic);
    }
    @Override
    public int getItemCount() {
        return 0;
    }
}
