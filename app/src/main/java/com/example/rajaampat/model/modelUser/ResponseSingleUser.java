package com.example.rajaampat.model.modelUser;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseSingleUser{

	@SerializedName("response_code")
	private String responseCode;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private String status;

	public void setResponseCode(String responseCode){
		this.responseCode = responseCode;
	}

	public String getResponseCode(){
		return responseCode;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseSingleUser{" + 
			"response_code = '" + responseCode + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}