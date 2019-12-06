package com.example.rajaampat.model.modelTransport;

import com.example.rajaampat.model.modelNews.NewsDataItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTransport {

    @SerializedName("response_code")
    private String responseCode;

    @SerializedName("data")
    private List<TransportDataItem> data;

    @SerializedName("is_error")
    private String isError;

    public String getResponseCode(){
        return responseCode;
    }

    public List<TransportDataItem> getData(){
        return data;
    }

    public String getIsError(){
        return isError;
    }

    @Override
    public String toString(){
        return
                "ResponseTransport{" +
                        "response_code = '" + responseCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",is_error = '" + isError + '\'' +
                        "}";
    }

}
