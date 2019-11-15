package com.example.rajaampat.editProfile;

import java.io.File;

public interface EditProfileContract {
    interface View{
        void setTextDataUmum();
        void pushEditProfile();
//        void setFotoProfile();
        void getPicFromCamera();
        void getPicFromGallery();
        void uploadPhotoSucces(String photo);
        void cropImageAutoSelection();
        void someThingFailed(String msg);
    }

    interface Presenter{
        void pushAll(EditProfilModel model);
    }
}
