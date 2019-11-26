package com.example.rajaampat.activity.reportActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.example.rajaampat.R;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;
import com.theartofdev.edmodo.cropper.CropImage;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class SendReportActivity extends AppCompatActivity {

    SharedPreferences myPref;

    Button btnSendReport;
    ImageView imgSendReport;
    EditText edtReportTitle, edtReportDesc, edtReportLocation;

    String status, isPublished;

    BaseApiService mApiService;

    ProgressDialog loading;

    File file;

    //Take photo
    private static final int RC_CAMERA = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    static final int REQUEST_CHOOSE_PHOTO = 2;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_report);

        myPref = getSharedPreferences("com.example.rajaampat_preferences", MODE_PRIVATE);

        mApiService = UtilsApi.getAPIService();

        loading = new ProgressDialog(SendReportActivity.this);
        loading.setMessage("Loading....");

        status = "1";
        isPublished = "1";

        imgSendReport = findViewById(R.id.img_send_report);
        edtReportDesc = findViewById(R.id.edt_report_desc);
        edtReportTitle = findViewById(R.id.edt_report_title);
        edtReportLocation = findViewById(R.id.edt_report_location);
        btnSendReport = findViewById(R.id.btn_send_report);

        btnSendReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogSendReport();
            }
        });
        imgSendReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCameraPermission();
                cropImageAutoSelection();
            }
        });
        checkCameraPermission();
        cropImageAutoSelection();
    }

    private void dialogSendReport() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(SendReportActivity.this);
        dialog.setTitle(R.string.sendReport);
        dialog.setMessage(R.string.messageSendReport);
        dialog.setPositiveButton("Send", null);
        dialog.setNegativeButton("Cancel", null);
        dialog.setCancelable(false);

        dialog.setPositiveButton(R.string.sendReport, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                sendReport();
            }
        });
        dialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.create();
        }
        dialog.show();
    }

    private void sendReport() {

        File filegambar;
        filegambar = file;

        loading.show();

        if (filegambar != null){
            AndroidNetworking.upload("https://raja-ampat.dfiserver.com/api/pengaduan/create")
                    .setPriority(Priority.HIGH)
                    .addHeaders("api_auth_key", "s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
                    .addMultipartParameter("judul_pengaduan", edtReportTitle.getText().toString())
                    .addMultipartParameter("ket_pengaduan", edtReportDesc.getText().toString())
                    .addMultipartParameter("pelapor", myPref.getString("user_name", "Tidak ada nama"))
                    .addMultipartParameter("status", status)
                    .addMultipartParameter("lokasi", edtReportLocation.getText().toString())
                    .addMultipartParameter("ispublished", isPublished)
                    .addMultipartFile("picture", filegambar)
                    .build()
                    .setUploadProgressListener(new UploadProgressListener() {
                        @Override
                        public void onProgress(long bytesUploaded, long totalBytes) {

                        }
                    })
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("response : ", "Berhasil upload Report");
                            Log.d("responseReport : ", response.toString());
                            Toast.makeText(SendReportActivity.this, "Berhasil upload Report", Toast.LENGTH_SHORT).show();
                            loading.dismiss();
                            finish();
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.d("error : ", "Gagal upload Report");
                            Log.d("errorBody : ", anError.getErrorBody());
                            Log.d("errorReport : ", anError.getErrorDetail());
                            Toast.makeText(SendReportActivity.this, anError.getErrorBody(), Toast.LENGTH_SHORT).show();
                            loading.dismiss();
                            finish();
                        }
                    });

//            mApiService.createReportRequest(
//                    edtReportTitle.getText().toString(),
//                    edtReportDesc.getText().toString(),
//                    myPref.getString("user_name", ""),
//                    status, filegambar)
//                    .enqueue(new Callback<ResponseReport>() {
//                        @Override
//                        public void onResponse(Call<ResponseReport> call, Response<ResponseReport> response) {
//                            try {
//                                Log.d("onResponse", response.body().getStatus());
//                            } catch (Exception e){
//                                e.printStackTrace();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseReport> call, Throwable t) {
//                            Log.d("onResponse", t.getLocalizedMessage());
//                        }
//                    });
        } else {
            Toast.makeText(this, "File gambar masih null", Toast.LENGTH_SHORT).show();
            Log.d("error", "File gambar masih null");
        }
    }

    public void cropImageAutoSelection() {
        CropImage.activity()
                .start(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            final Bitmap bitmap = (Bitmap) extras.get("data");
            //ByteArrayOutputStream bos = new ByteArrayOutputStream();
            //bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);

            File filesDir = getApplicationContext().getFilesDir();
            File imageFile = new File(filesDir, "image" + ".jpg");

            OutputStream os;
            try {
                os = new FileOutputStream(imageFile);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
                os.flush();
                os.close();
                file = imageFile;
                imgSendReport.setImageBitmap(bitmap);

            } catch (Exception e) {
                Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
            }
        } else if (requestCode == REQUEST_CHOOSE_PHOTO && resultCode == RESULT_OK){

            Uri uri = data.getData();

        }
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK ){
                Uri imageUri = result.getUri();
                try {
                    Bitmap bitmap = (Bitmap) MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

                    File filesDir = getApplicationContext().getFilesDir();
                    File imageFile = new File(filesDir, "image" + ".jpg");

                    OutputStream os;
                    os = new FileOutputStream(imageFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
                    os.flush();
                    os.close();
                    this.file = imageFile;
                    imgSendReport.setImageBitmap(bitmap);

                } catch (IOException e) {
                    Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
                    e.printStackTrace();
                }

            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void recreate() {
        super.recreate();
    }

    @AfterPermissionGranted(RC_CAMERA)
    private void checkCameraPermission() {
        String perm = Manifest.permission.CAMERA;
        if (EasyPermissions.hasPermissions(this, perm)) {
        } else {
            EasyPermissions.requestPermissions(this, "Butuh permission camera", RC_CAMERA, perm);
        }
    }

    public void getPicFromCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }

    public void getPicFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CHOOSE_PHOTO);
    }

}
