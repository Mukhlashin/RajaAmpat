package com.example.rajaampat.reportActivity;

import android.util.Log;

import com.example.rajaampat.editProfile.EditProfileContract;
import com.example.rajaampat.model.modelReport.ResponseReport;
import com.example.rajaampat.network.BaseApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportPresenter implements ReportInterface.Presenter {

    ReportInterface.View view;
    BaseApiService mApiService;

    public ReportPresenter(ReportInterface.View view) {
        this.view = view;
    }

    @Override
    public void getDataReport() {
        mApiService.reportRequest()
                .enqueue(new Callback<ResponseReport>() {
                    @Override
                    public void onResponse(Call<ResponseReport> call, Response<ResponseReport> response) {
                        Log.d("onResponse", response.message());
                        String judulReport = response.body().getData().get(0).getJudulPengaduan();
                        String pelaporReport = response.body().getData().get(0).getPelapor();
                        String pictureReport = response.body().getData().get(0).getPicture();
                        String responReport = response.body().getData().get(0).getRespon();
                        String ketPengaduanReport = response.body().getData().get(0).getKetPengaduan();
                    }

                    @Override
                    public void onFailure(Call<ResponseReport> call, Throwable t) {
                        Log.d("onError", t.getLocalizedMessage());
                    }
                });
    }
}
