package com.example.rajaampat.activity.reportActivity;

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

import com.example.rajaampat.R;
import com.example.rajaampat.model.modelReport.ReportDataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReportActivityAdapter extends RecyclerView.Adapter<ReportActivityAdapter.ReportViewHolder> {

    private List<ReportDataItem> list;
    private Context context;
    private ReportActivity view;

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
    public void onBindViewHolder(@NonNull ReportViewHolder holder, final int position) {
        holder.tvJudul.setText(list.get(position).getJudulPengaduan());
        holder.tvStatus.setText(list.get(position).getStatus());

        if (list.get(position).getRespon() == null){
            holder.tvResponAdmin.setText("Belum ada respon dari Admin");
        } else {
            holder.tvResponAdmin.setText(list.get(position).getRespon());
        }

        String status = list.get(position).getStatus();
        if(status.equals("1")){
            holder.tvStatus.setText("Open");
            holder.btnStatus.setBackground(context.getResources().getDrawable(R.drawable.circle_back1));
        }else if(status.equals("2")){
            holder.tvStatus.setText("Process");
            holder.btnStatus.setBackground(context.getResources().getDrawable(R.drawable.circle_back2));
        }else if(status.equals("3")){
            holder.tvStatus.setText("Closed");
            holder.btnStatus.setBackground(context.getResources().getDrawable(R.drawable.circle_back3));
        }

        holder.tvPelapor.setText("Pelapor : " + list.get(position).getPelapor());
        holder.tvPengaduan.setText(list.get(position).getKetPengaduan());
        holder.tvAdmin.setText("Admin");
        holder.imgLogo.setImageResource(R.drawable.lra);
        Picasso.get().load(list.get(position).getPicture()).into(holder.imgReport);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentData = new Intent(context, DetailReportActivity.class);
                intentData.putExtra("judulReport", list.get(position).getJudulPengaduan());
                intentData.putExtra("pelaporReport", list.get(position).getPelapor());
                intentData.putExtra("keteranganReport", list.get(position).getKetPengaduan());
                intentData.putExtra("pictureReport", list.get(position).getPicture());
                intentData.putExtra("lokasiReport", list.get(position).getLokasi());
                intentData.putExtra("statusReport", list.get(position).getStatus());
                intentData.putExtra("responAdmin", list.get(position).getRespon());
                context.startActivity(intentData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ReportViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvPelapor, tvPengaduan, tvResponAdmin, tvStatus, tvAdmin;
        ImageView imgReport, imgLogo;
        Button btnStatus;
        public ReportViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tv_judul_report);
            tvPelapor = itemView.findViewById(R.id.tv_pelapor);
            tvPengaduan = itemView.findViewById(R.id.tv_pengaduan);
            tvResponAdmin = itemView.findViewById(R.id.tv_respon_admin);
            tvStatus = itemView.findViewById(R.id.tv_status_report);
            imgReport = itemView.findViewById(R.id.img_report);
            tvAdmin = itemView.findViewById(R.id.tv_admin);
            imgLogo = itemView.findViewById(R.id.img_logo);
            btnStatus = itemView.findViewById(R.id.btn_status);

        }
    }
}
