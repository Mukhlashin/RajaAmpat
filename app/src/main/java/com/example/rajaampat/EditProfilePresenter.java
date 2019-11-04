package com.example.rajaampat;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;

public class EditProfilePresenter implements EditProfileContract.Presenter {
    EditProfileContract.View view;
    int SUCCESS_FULL_PUSH_CODE = 200;
    boolean[] booleans = {false, false, false};

    public EditProfilePresenter(EditProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void pushEditProfile(String[] dataUser) {
        pushDataUmum(dataUser);
    }

    @Override
    public void pushDataUmum(String[] dataUser) {

        AndroidNetworking.post("https://raja-ampat.dfiserver.com/api/users/id/")
                .setPriority(Priority.HIGH)
                .addBodyParameter("user_name", dataUser[0])
                .addBodyParameter("no_tlp", dataUser[1])
                .addBodyParameter("no_ktp", dataUser[2])
                .addBodyParameter("tgl_lahir", dataUser[3])
                .addBodyParameter("tempat_lahir", dataUser[4])
                .addBodyParameter("alamat", dataUser[5])
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            try {
                                if (response.getString("error").equals("false")) {
                                    booleans[0] = true;
                                    if(booleans[0] == true && booleans[1] == true && booleans[2] == true){view.updateSucces();}
                                    Log.d("BOOLEANS" , java.util.Arrays.toString(booleans));
                                } else if (response.getString("error").equals("true")) {
                                    view.updateFailed(response.getString("msg"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                view.updateFailed(e.getLocalizedMessage());
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.updateFailed(anError.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void pushPhoto(File file) {
        AndroidNetworking.upload("https://raja-ampat.dfiserver.com/api/users/id/")
                .setPriority(Priority.HIGH)
                .addMultipartFile("pic", file)
                .build()
                .setUploadProgressListener(new UploadProgressListener() {
                    @Override
                    public void onProgress(long bytesUploaded, long totalBytes) {

                    }
                }).getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {

            }

            @Override
            public void onError(ANError anError) {

            }
        });
    }

}
