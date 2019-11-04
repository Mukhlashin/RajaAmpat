package com.example.rajaampat;

import java.io.File;

public interface EditProfileContract {
    interface View{
        void setTextDataUmum();
        void updateSucces();
        void updateFailed(String message);
        void pushEditProfile();
        void pushPhoto(File imageFile);


    }

    interface Presenter{
        void pushEditProfile(String[] dataUser);
        void pushDataUmum(String[] dataUser);
        void pushPhoto(File file);
    }
}
