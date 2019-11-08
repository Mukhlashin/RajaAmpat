package com.example.rajaampat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class EditProfileActivity extends AppCompatActivity implements EditProfileContract.View {
    EditProfilePresenter presenter;
    SharedPreferences userInformation;
    SharedPreferences userInformation2;
    SharedPreferences.Editor editorUserInformation;

    //Data user
    EditText dataNama, dataTlp, dataKtp, dataTglLahir, dataTmpLahir, dataAlamat;

    //button
    Button btnUpdateProfile;

    //Toolbar
    ImageView back, imgProfile;

    //Take photo
    private static final int RC_CAMERA = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    static final int REQUEST_CHOOSE_PHOTO = 2;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    Dialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        //for Toolbar
        back = findViewById(R.id.kembali_editprofile);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //setup
        presenter = new EditProfilePresenter(this);
        userInformation = getSharedPreferences("userInfo", MODE_PRIVATE);
        userInformation2 = getSharedPreferences("com.example.rajaampat_preferences", MODE_PRIVATE);

        //setupdata
        //data umum
        dataNama = findViewById(R.id.edt_nama);
        dataTlp = findViewById(R.id.edt_tlp);
        dataKtp = findViewById(R.id.edt_ktp);
        dataTglLahir = findViewById(R.id.edt_tanggal_lahir);
        dataTmpLahir = findViewById(R.id.edt_tempat_lahir);
        dataAlamat = findViewById(R.id.edt_alamat);
        imgProfile = findViewById(R.id.img_profile);
        setTextDataUmum();

        loading = new Dialog(this);
        loading.setContentView(R.layout.loading_layout);
        loading.setCancelable(false);
        loading.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnUpdateProfile = findViewById(R.id.btn_simpanedit);
        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushEditProfile();
            }
        });

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCameraPermission();
                cropImageAutoSelection();
            }
        });

        //editText date
        dataTglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar newCalendar = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(EditProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, month, dayOfMonth);
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                        dataTglLahir.setText(dateFormatter.format(newDate.getTime()).toString());
                    }
                },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent backToProfile = new Intent(EditProfileActivity.this, HomeActivity.class);
        startActivity(backToProfile);
        finish();
    }

    @Override
    public void setTextDataUmum() {
        String strNama, strTlp, strKtp, strTglLahir, strTmpLahir, strAlamat, strKecamatan, strKelurahan;

        strNama = userInformation.getString("user_name", "");
        strTlp = userInformation.getString("no_tlp", "");
        strKtp = userInformation.getString("no_ktp", "");
        strTglLahir = userInformation.getString("tgl_lahir", "");
        strTmpLahir = userInformation.getString("tempat_lahir", "");
        strAlamat = userInformation.getString("alamat", "");

        if(strNama.equals("null")||strNama.equals("")){
        }else {
            dataNama.setText(strNama);
        }

        if(strTlp.equals("null")||strTlp.equals("")){
        }else {
            dataTlp.setText(strTlp);
        }

        if(strKtp.equals("null")||strKtp.equals("")){
        }else {
            dataKtp.setText(strKtp);
        }

        if(strTglLahir.equals("null")||strTglLahir.equals("")){
        }else {
            dataTglLahir.setText(strTglLahir);
        }

        if(strTmpLahir.equals("null")||strTmpLahir.equals("")){
        }else {
            dataTmpLahir.setText(strTmpLahir);
        }

        if(strAlamat.equals("null")||strAlamat.equals("")){
        }else {
            dataAlamat.setText(strAlamat);
        }
    }

    @Override
    public void updateSucces() {
        onBackPressed();
        Toast.makeText(EditProfileActivity.this, "Sukses mengupdate profil :)", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateFailed(String message) {
        Toast.makeText(this, "Gagal :'(", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pushEditProfile() {

        String pushNama = dataNama.getText().toString();
        String pushTlp = dataTlp.getText().toString();
        String pushKtp = dataKtp.getText().toString();
        String pushTglLahir = dataTglLahir.getText().toString();
        String pushTmpLahir = dataTmpLahir.getText().toString();
        String pushAlamat = dataAlamat.getText().toString();

        String[] dataUser = {pushNama, pushTlp, pushKtp, pushTglLahir, pushTmpLahir, pushAlamat};

        presenter.pushEditProfile(dataUser);

    }

    @Override
    public void pushPhoto(File imageFile) {
        presenter.pushPhoto(userInformation2.getString("id", ""), imageFile);
    }

    @Override
    public void someThingFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
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
                pushPhoto(imageFile);

            } catch (Exception e) {
                Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
            }
            pushPhoto(imageFile);
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

                    pushPhoto(imageFile);

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

    @AfterPermissionGranted(RC_CAMERA)
    private void checkCameraPermission() {
        String perm = Manifest.permission.CAMERA;
        if (EasyPermissions.hasPermissions(this, perm)) {
        } else {
            EasyPermissions.requestPermissions(this, "Butuh permission camera", RC_CAMERA, perm);
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

    @Override
    public void getPicFromCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }

    @Override
    public void getPicFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CHOOSE_PHOTO);
    }

    @Override
    public void uploadPhotoSucces(String photo) {
        editorUserInformation
                .putString("picture", "https://raja-ampat.dfiserver.com/api/users/id/" + photo)
                .commit();
        recreate();
    }
}