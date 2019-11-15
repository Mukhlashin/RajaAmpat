package com.example.rajaampat.reportActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rajaampat.ContactActivity;
import com.example.rajaampat.R;
import com.example.rajaampat.model.modelReport.ReportDataItem;
import com.example.rajaampat.model.modelReport.ResponseReport;
import com.example.rajaampat.network.BaseApiService;
import com.example.rajaampat.network.UtilsApi;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ImageButton btnBack, btnContact, btnMore, btnAdd;
    ImageView imgReport;
    RecyclerView rvReport;
    ProgressDialog loading;
    ReportActivityAdapter adapter;
    List<ReportDataItem> data;
    BaseApiService mApiService;

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
        setContentView(R.layout.activity_report);

        loading = new ProgressDialog(ReportActivity.this);
        loading.setMessage("Loading....");
        loading.show();

        mApiService = UtilsApi.getAPIService();

        btnBack = findViewById(R.id.btn_back);
        btnContact = findViewById(R.id.btn_contact);
        btnMore = findViewById(R.id.btn_more);
        btnAdd = findViewById(R.id.btn_add_report);
        imgReport = findViewById(R.id.img_report);
        rvReport = findViewById(R.id.rv_report);
        rvReport.setAdapter(adapter);
        getDataReport();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCameraPermission();
                cropImageAutoSelection();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToContact();
            }

            private void goToContact() {
                Intent goToContact = new Intent(ReportActivity.this,  ContactActivity.class);
                startActivity(goToContact);
            }
        });
    }

    private void getDataReport() {
        mApiService.reportRequest()
                .enqueue(new Callback<ResponseReport>() {
                    @Override
                    public void onResponse(Call<ResponseReport> call, Response<ResponseReport> response) {
                        if (response.isSuccessful()) {
                            data = response.body().getData();
                            adapter = new ReportActivityAdapter(ReportActivity.this, data);
                            rvReport.setLayoutManager(new LinearLayoutManager(ReportActivity.this));
                            rvReport.setAdapter(adapter);
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseReport> call, Throwable t) {
                        Log.d("onFailure", t.getLocalizedMessage());
                        loading.dismiss();
                    }
                });
    }

    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.main_menu);
        popupMenu.show();
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
                imgReport.setImageBitmap(bitmap);

            } catch (Exception e) {
                Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
            }
        } else if (requestCode == REQUEST_CHOOSE_PHOTO && resultCode == RESULT_OK){

            Uri uri = data.getData();

            //try crop
            CropImage.activity(uri).setAspectRatio(1,1).start(this);

        }

        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
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
//                    imgProfile.setImageBitmap(bitmap);

                } catch (IOException e) {
                    Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
                    e.printStackTrace();
                }

            }
        }
    }

    public void cropImageAutoSelection() {
        CropImage.activity()
                .setAspectRatio(2,3)
                .start(this);
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

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.tester :
                Toast.makeText(this, "Tester Berhasil", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tester2 :
                Toast.makeText(this, "Tester2 Berhasil", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tester3 :
                Toast.makeText(this, "Tester3 Berhasil", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
