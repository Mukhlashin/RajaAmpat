package com.example.rajaampat.model.modelForgotPassword;

import com.google.gson.annotations.SerializedName;

public class ResponseForgotPassword{

	@SerializedName("response_code")
	private String responseCode;

	@SerializedName("response_message")
	private String responseMessage;

	@SerializedName("status")
	private String status;

	public void setResponseCode(String responseCode){
		this.responseCode = responseCode;
	}

	public String getResponseCode(){
		return responseCode;
	}

	public void setResponseMessage(String responseMessage){
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage(){
		return responseMessage;
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
			"ResponseForgotPassword{" + 
			"response_code = '" + responseCode + '\'' + 
			",response_message = '" + responseMessage + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}