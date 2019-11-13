package com.example.rajaampat.reportActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajaampat.DetailNewsActivity;
import com.example.rajaampat.R;
import com.example.rajaampat.model.modelReport.ReportDataItem;
import com.example.rajaampat.model.modelReport.ResponseReport;
import com.example.rajaampat.network.BaseApiService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivityAdapter extends RecyclerView.Adapter<ReportActivityAdapter.ReportViewHolder> {

    private List<ReportDataItem> list;
    private Context context;

    public ReportActivityAdapter(Context context, List<ReportDataItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemview_report_activity, null);
        return new ReportActivityAdapter.ReportViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        holder.tvJudul.setText(list.get(position).getJudulPengaduan());
        holder.tvStatus.setText(list.get(position).getStatus());
        holder.tvResponAdmin.setText(list.get(position).getRespon());
        holder.tvPelapor.setText(list.get(position).getPelapor());
        holder.tvPengaduan.setText(list.get(position).getKetPengaduan());
        Picasso.get().load(list.get(position).getPicture()).into(holder.imgReport);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentData = new Intent(context, DetailNewsActivity.class);
//                intentData.putExtra("detailArtikel", list.get(position).getDetilArtikel());
//                intentData.putExtra("judulArtikel", list.get(position).getJudulArtikel());
//                intentData.putExtra("pictureArtikel", list.get(position).getPicture());
//                context.startActivity(intentData);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvPelapor, tvPengaduan, tvResponAdmin, tvStatus;
        ImageView imgReport;
        Button btnStatus;
        public ReportViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tv_judul_report);
            tvPelapor = itemView.findViewById(R.id.tv_pelapor);
            tvPengaduan = itemView.findViewById(R.id.tv_pengaduan);
            tvResponAdmin = itemView.findViewById(R.id.tv_respon_admin);
            tvStatus = itemView.findViewById(R.id.tv_status_report);
            imgReport = itemView.findViewById(R.id.img_report);
            btnStatus = itemView.findViewById(R.id.btn_status);

        }
    }
}
