package com.example.rajaampat.activity.editProfileActivity;

public interface EditProfileContract {
    interface View{
        void setTextDataUmum();
        void pushEditProfile();
        void setFotoProfile();
        void getPicFromCamera();
        void getPicFromGallery();
        void uploadPhotoSucces(String photo);
        void cropImageAutoSelection();
        void showLoading();
        void hideLoading();
        void someThingFailed(String msg);
    }

    interface Presenter{
        void pushAll(EditProfilModel model);
    }
}
