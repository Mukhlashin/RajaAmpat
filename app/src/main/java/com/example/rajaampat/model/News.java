package com.example.rajaampat.model;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("id")
    private int artikel_id;
    @SerializedName("judul")
    private String judul;
    @SerializedName("detail")
    private String detail_artikel;
    @SerializedName("picture")
    private int picture;
    @SerializedName("publish")
    private String intpublished;

    public News(){}

    public News(int artikel_id, String judul, String detail_artikel, int picture, String intpublished){
        this.artikel_id = artikel_id;
        this.judul = judul;
        this.detail_artikel = detail_artikel;
        this.picture = picture;
        this.intpublished = intpublished;
    }

    public int getArtikel_id(){
        return artikel_id;
    }

    public String getJudul(){
        return judul;
    }

    public String getDetail_artikel(){
        return detail_artikel;
    }

    public int getPicture(){
        return picture;
    }

    public String getIntpublished(){
        return intpublished;
    }
}


