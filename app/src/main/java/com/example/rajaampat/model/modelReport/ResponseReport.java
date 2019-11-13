package com.example.rajaampat.model.modelReport;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseReport{

	@SerializedName("response_code")
	private String responseCode;

	@SerializedName("data")
	private List<ReportDataItem> data;

	@SerializedName("status")
	private String status;

	public String getResponseCode(){
		return responseCode;
	}

	public List<ReportDataItem> getData(){
		return data;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseReport{" + 
			"response_code = '" + responseCode + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}