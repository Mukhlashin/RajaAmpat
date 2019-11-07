package com.example.rajaampat;

import java.io.File;

public interface EditProfileContract {
    interface View{
        void setTextDataUmum();
        void updateSucces();
        void updateFailed(String message);
        void pushEditProfile();
        void getPicFromCamera();
        void getPicFromGallery();
        void uploadPhotoSucces(String photo);
        void cropImageAutoSelection();
        void pushPhoto(File imageFile);
        void someThingFailed(String msg);
    }

    interface Presenter{
        void pushEditProfile(String[] dataUser);
        void pushDataUmum(String[] dataUser);
        void pushPhoto(String userId, File file);
    }
}
