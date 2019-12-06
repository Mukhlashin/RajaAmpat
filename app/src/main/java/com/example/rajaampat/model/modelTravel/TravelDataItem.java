package com.example.rajaampat.model.modelTravel;

import com.google.gson.annotations.SerializedName;

public class TravelDataItem {

    @SerializedName("id_tujuan_wisata")
    private String idTujuanWisata;

    @SerializedName("nama_tujuan_wisata")
    private String namaTujuanWisata;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("picture")
    private String picture;

    @SerializedName("main_pict")
    private String mainPicture;

    @SerializedName("ispublished")
    private String ispublished;

    public String getIdTujuanWisata(){
        return idTujuanWisata;
    }

    public String getNamaTujuanWisata(){
        return namaTujuanWisata;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public String getPicture(){
        return picture;
    }

    public String getMainPicture(){
        return mainPicture;
    }

    public String getIspublished(){
        return ispublished;
    }

    @Override
    public String toString(){
        return
                "NewsDataItem{" +
                        "id_tujuan_wisata = '" + idTujuanWisata + '\'' +
                        ",nama_tujuan_wisata = '" + namaTujuanWisata + '\'' +
                        ",deskripsi = '" + deskripsi + '\'' +
                        ",picture = '" + picture + '\'' +
                        ",main_icture = '" + mainPicture + '\'' +
                        ",ispublished = '" + ispublished + '\'' +
                        "}";
    }
}
