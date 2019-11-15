package com.example.rajaampat.model.modelReport;

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
                        ",ispublished = '" + ispublished + '\'' +
                        "}";
    }
}
