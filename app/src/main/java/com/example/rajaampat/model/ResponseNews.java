package com.example.rajaampat.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseNews{

	@SerializedName("response_code")
	private String responseCode;

	@SerializedName("data")
	private List<NewsDataItem> data;

	@SerializedName("is_error")
	private String isError;

	public String getResponseCode(){
		return responseCode;
	}

	public List<NewsDataItem> getData(){
		return data;
	}

	public String getIsError(){
		return isError;
	}

	@Override
 	public String toString(){
		return 
			"ResponseNews{" + 
			"response_code = '" + responseCode + '\'' + 
			",data = '" + data + '\'' + 
			",is_error = '" + isError + '\'' + 
			"}";
		}
}