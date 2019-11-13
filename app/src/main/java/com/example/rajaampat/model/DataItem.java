package com.example.rajaampat.model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("device_name")
	private String deviceName;

	@SerializedName("nama")
	private String nama;

	@SerializedName("tempat_lahir")
	private String tempatLahir;

	@SerializedName("no_tlp")
	private String noTlp;

	@SerializedName("device_id")
	private String deviceId;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("no_ktp")
	private String noKtp;

	@SerializedName("email")
	private String email;

	@SerializedName("tgl_lahir")
	private String tglLahir;

	@SerializedName("picture")
	private Object picture;

	@SerializedName("alamat")
	private String alamat;

	public void setDeviceName(String deviceName){
		this.deviceName = deviceName;
	}

	public String getDeviceName(){
		return deviceName;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setTempatLahir(String tempatLahir){
		this.tempatLahir = tempatLahir;
	}

	public String getTempatLahir(){
		return tempatLahir;
	}

	public void setNoTlp(String noTlp){
		this.noTlp = noTlp;
	}

	public String getNoTlp(){
		return noTlp;
	}

	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;
	}

	public String getDeviceId(){
		return deviceId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setNoKtp(String noKtp){
		this.noKtp = noKtp;
	}

	public String getNoKtp(){
		return noKtp;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setTglLahir(String tglLahir){
		this.tglLahir = tglLahir;
	}

	public String getTglLahir(){
		return tglLahir;
	}

	public void setPicture(Object picture){
		this.picture = picture;
	}

	public Object getPicture(){
		return picture;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	@Override
 	public String toString(){
		return 
			"ReportDataItem{" +
			"device_name = '" + deviceName + '\'' + 
			",nama = '" + nama + '\'' + 
			",tempat_lahir = '" + tempatLahir + '\'' + 
			",no_tlp = '" + noTlp + '\'' + 
			",device_id = '" + deviceId + '\'' + 
			",user_id = '" + userId + '\'' + 
			",user_name = '" + userName + '\'' + 
			",no_ktp = '" + noKtp + '\'' + 
			",email = '" + email + '\'' + 
			",tgl_lahir = '" + tglLahir + '\'' + 
			",picture = '" + picture + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}