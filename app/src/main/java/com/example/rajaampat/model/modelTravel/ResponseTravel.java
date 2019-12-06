package com.example.rajaampat.model.modelTravel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseTravel{

    @SerializedName("response_code")
    private String responseCode;

    @SerializedName("data")
    private List<TravelDataItem> data;

    @SerializedName("is_error")
    private String isError;

    public String getResponseCode(){
        return responseCode;
    }

    public List<TravelDataItem> getData(){
        return data;
    }

    public String getIsError(){
        return isError;
    }

    @Override
    public String toString(){
        return
                "ResponseTravel{" +
                        "response_code = '" + responseCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",is_error = '" + isError + '\'' +
                        "}";
    }
}