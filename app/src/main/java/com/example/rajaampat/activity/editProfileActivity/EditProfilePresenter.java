package com.example.rajaampat.activity.editProfileActivity;

import android.content.SharedPreferences;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;

import org.json.JSONObject;

public class EditProfilePresenter implements EditProfileContract.Presenter {

    EditProfileContract.View view;
    int SUCCESS_FULL_PUSH_CODE = 200;
    boolean[] booleans = {false, false, false};

    SharedPreferences myPref;

    public EditProfilePresenter(EditProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void pushAll(EditProfilModel model) {
        AndroidNetworking.upload("https://raja-ampat.dfiserver.com/api/users/update")
                .setPriority(Priority.HIGH)
                .addHeaders("api_auth_key", "s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
                .addMultipartFile("picture", model.getFileGambar())
                .addMultipartParameter("id", model.getId())
                .addMultipartParameter("user_name", model.getNama())
                .addMultipartParameter("no_ktp", model.getKtp())
                .addMultipartParameter("alamat", model.getAlamat())
                .addMultipartParameter("email", model.getEmail())
                .addMultipartParameter("tgl_lahir", model.getTanggalLahir())
                .addMultipartParameter("tempat_lahir", model.getTempatLahir())
                .addMultipartParameter("no_tlp", model.getTelpon())
                .build()
                .setUploadProgressListener(new UploadProgressListener() {
                    @Override
                    public void onProgress(long bytesUploaded, long totalBytes) {

                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        view.uploadPhotoSucces("Photo selesai di upload!");
                        Log.d("UploadFoto", "BERHASIL");
                        Log.d("UploadFoto", response.toString());
                        view.hideLoading();
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("UploadFoto", anError.getErrorDetail());
                        Log.d("UploadFoto", anError.getErrorBody());
                        view.hideLoading();
                    }
                });
    }
}
