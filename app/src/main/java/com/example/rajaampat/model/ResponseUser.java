package com.example.rajaampat.model;

import com.google.gson.annotations.SerializedName;

public class ResponseUser{

	@SerializedName("response_code")
	private String responseCode;

	@SerializedName("response_message")
	private String responseMessage;

	@SerializedName("picture_full_path")
	private String pictureFullPath;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("nama")
	private String nama;

	@SerializedName("tempat_lahir")
	private String tempatLahir;

	@SerializedName("tanggal_lahir")
	private String tanggalLahir;

	@SerializedName("no_tlp")
	private String nomorTelepon;

	@SerializedName("no_ktp")
	private String nomorKTP;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("is_error")
	private String isError;

	@SerializedName("device_id")
	private String deviceID;

	@SerializedName("device_name")
	private String deviceName;

	@SerializedName("picture")
	private Object picture;

	@SerializedName("email")
	private String email;

	@SerializedName("pwd")
	private String password;

	public void setResponseCode(String responseCode){
		this.responseCode = responseCode;
	}

	public String getResponseCode(){
		return responseCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setResponseMessage(String responseMessage){
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage(){
		return responseMessage;
	}

	public void setPictureFullPath(String pictureFullPath){
		this.pictureFullPath = pictureFullPath;
	}

	public String getPictureFullPath(){
		return pictureFullPath;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setTempatLahir(String tempatLahir){
		this.tempatLahir = tempatLahir;
	}

	public String getTempatLahir(){
		return tempatLahir;
	}

	public void setTanggalLahir(String tanggalLahir){
		this.tanggalLahir = tanggalLahir;
	}

	public String getTanggalLahir(){
		return tanggalLahir;
	}

	public void setNomorTelepon(String nomorTelepon){
		this.nomorTelepon = nomorTelepon;
	}

	public String getNomorTelepon(){
		return nomorTelepon;
	}

	public void setNomorKTP(String nomorKTP){
		this.nomorKTP = nomorKTP;
	}

	public String getNomorKTP(){
		return nomorKTP;
	}

	public void setDeviceID(String deviceID){
		this.deviceID = deviceID;
	}

	public void setDeviceName(String deviceName){
		this.deviceName = deviceName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setIsError(String isError){
		this.isError = isError;
	}

	public String getIsError(){
		return isError;
	}

	public void setPicture(Object picture){
		this.picture = picture;
	}

	public Object getPicture(){
		return picture;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"ResponseUser{" + 
			"response_code = '" + responseCode + '\'' + 
			",response_message = '" + responseMessage + '\'' + 
			",picture_full_path = '" + pictureFullPath + '\'' + 
			",user_id = '" + userId + '\'' + 
			",user_name = '" + userName + '\'' +
			",nama = '" + nama + '\'' +
			",alamat = '" + alamat + '\'' +
			",tempat_lahir = '" + tempatLahir + '\'' +
			",tanggal_lahir = '" + tanggalLahir + '\'' +
			",no_tlp = '" + nomorTelepon + '\'' +
			",no_ktp = '" + nomorKTP + '\'' +
			",is_error = '" + isError + '\'' +
			",device_id = '" + deviceID + '\'' +
			",device_name = '" + deviceName + '\'' +
			",picture = '" + picture + '\'' +
			",email = '" + email + '\'' + 
			"}";
		}
}