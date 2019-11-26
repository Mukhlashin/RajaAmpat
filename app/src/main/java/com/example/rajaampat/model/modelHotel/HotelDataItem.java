package com.example.rajaampat.model.modelHotel;

import com.google.gson.annotations.SerializedName;

public class HotelDataItem {

    @SerializedName("id_hotel")
    private String idHotel;

    @SerializedName("nama_hotel")
    private String namaHotel;

    @SerializedName("alamat")
    private String alamatHotel;

    @SerializedName("kota")
    private String kotaHotel;

    @SerializedName("kode_pos")
    private String kodePosHotel;

    @SerializedName("no_tlp")
    private String noTlp;

    @SerializedName("email")
    private String emailHotel;

    @SerializedName("harga_kamar")
    private String hargaKamar;

    @SerializedName("picture")
    private String picture;

    @SerializedName("ispublished")
    private String ispublished;

    public String getIdHotel(){
        return idHotel;
    }

    public String getNamaHotel(){
        return namaHotel;
    }

    public String getAlamatHotel(){
        return alamatHotel;
    }

    public String getKotaHotel(){
        return kotaHotel;
    }

    public String getKodePosHotel(){
        return kodePosHotel;
    }

    public String getNoTlp(){
        return noTlp;
    }

    public String getEmailHotel(){
        return emailHotel;
    }

    public String getHargaKamar(){
        return hargaKamar;
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
                "HotelDataItem{" +
                        "id_hotel = '" + idHotel + '\'' +
                        ",nama_hotel = '" + namaHotel + '\'' +
                        ",alamat = '" + alamatHotel + '\'' +
                        ",kota = '" + kotaHotel + '\'' +
                        ",kode_pos = '" + kodePosHotel + '\'' +
                        ",no_tlp = '" + noTlp + '\'' +
                        ",email = '" + emailHotel + '\'' +
                        ",harga_kamar = '" + hargaKamar + '\'' +
                        ",picture = '" + picture + '\'' +
                        ",ispublished = '" + ispublished + '\'' +
                        "}";
    }
}