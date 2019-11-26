package com.example.rajaampat.model.modelContact;

import com.google.gson.annotations.SerializedName;

public class ContactDataItem {

    @SerializedName("id_contact")
    private String idKontak;

    @SerializedName("instansi_kontak")
    private String namaInstansi;

    @SerializedName("nomor_kontak")
    private String nomorInstansi;

    @SerializedName("picture")
    private String picture;

    public String getIdKontak() {
        return idKontak;
    }

    public String getNamaInstansi() {
        return namaInstansi;
    }

    public String getNomorInstansi() {
        return nomorInstansi;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return
                "ContactDataItem{" +
                        "id_kontak = '" + idKontak + '\'' +
                        ",nama_kontak = '" + namaInstansi + '\'' +
                        ",nomor_kontak = '" + nomorInstansi + '\'' +
                        ",picture = '" + picture + '\'' +
                        "}";

    }
}
