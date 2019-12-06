package com.example.rajaampat.model.modelContact;

import com.google.gson.annotations.SerializedName;

public class ContactDataItem {

    @SerializedName("id_call_center")
    private String idKontak;

    @SerializedName("nm_call_center")
    private String namaInstansi;

    @SerializedName("no_call_center")
    private String nomorInstansi;

    @SerializedName("logo")
    private String logo;

    @SerializedName("is_published")
    private String isPublished;

    public String getIdKontak() {
        return idKontak;
    }

    public String getNamaInstansi() {
        return namaInstansi;
    }

    public String getNomorInstansi() {
        return nomorInstansi;
    }

    public String getLogo() {
        return logo;
    }

    public String getIsPublished() {
        return isPublished;
    }

    @Override
    public String toString() {
        return
                "ContactDataItem{" +
                        "id_kontak = '" + idKontak + '\'' +
                        ",nama_kontak = '" + namaInstansi + '\'' +
                        ",nomor_kontak = '" + nomorInstansi + '\'' +
                        ",picture = '" + logo + '\'' +
                        ",is_published = '" + isPublished + '\'' +
                        "}";

    }
}
