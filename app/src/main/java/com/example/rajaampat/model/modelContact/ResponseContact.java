package com.example.rajaampat.model.modelContact;

import com.example.rajaampat.model.modelHotel.HotelDataItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseContact {

    @SerializedName("response_code")
    private String responseCode;

    @SerializedName("data")
    private List<ContactDataItem> data;

    @SerializedName("is_error")
    private String isError;

    public String getResponseCode() {
        return responseCode;
    }

    public List<ContactDataItem> getData() {
        return data;
    }

    public String getIsError() {
        return isError;
    }

    @Override
    public String toString() {
        return
                "ResponseContact{" +
                        "response_code = '" + responseCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",is_error = '" + isError + '\'' +
                        "}";
    }

}
