package com.example.rajaampat.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResponseHotel {

    @SerializedName("response_code")
    private String responseCode;

    @SerializedName("data")
    private List<HotelDataItem> data;

    @SerializedName("is_error")
    private String isError;

    public String getResponseCode() {
        return responseCode;
    }

    public List<HotelDataItem> getData() {
        return data;
    }

    public String getIsError() {
        return isError;
    }

    @Override
    public String toString() {
        return
                "ResponseHotel{" +
                "response_code = '" + responseCode + '\'' +
                ",data = '" + data + '\'' +
                ",is_error = '" + isError + '\'' +
                "}";
    }
}
