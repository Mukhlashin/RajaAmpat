package com.example.rajaampat.model.modelTransport;

import com.google.gson.annotations.SerializedName;

public class TransportDataItem {

    @SerializedName("transport_id")
    private String transportId;

    @SerializedName("picture")
    private String picture;

    public String getTransportId() {
        return transportId;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return
                "TransportDataItem{" +
                        "artikel_id = '" + transportId + '\'' +
                        ",judul_artikel = '" + picture + '\'' +
                        "}";
    }
}
