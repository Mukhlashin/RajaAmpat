package com.example.rajaampat.model.modelReport;

import com.google.gson.annotations.SerializedName;

public class ReportDataItem {

	@SerializedName("judul_pengaduan")
	private String judulPengaduan;

	@SerializedName("respon")
	private String respon;

	@SerializedName("ispublished")
	private String ispublished;

	@SerializedName("ket_pengaduan")
	private String ketPengaduan;

	@SerializedName("pelapor")
	private String pelapor;

	@SerializedName("id_pengaduan")
	private String idPengaduan;

	@SerializedName("picture")
	private String picture;

	@SerializedName("status")
	private String status;

	@SerializedName("lokasi")
	private String lokasi;

	public String getJudulPengaduan(){
		return judulPengaduan;
	}

	public String getRespon(){
		return respon;
	}

	public String getIspublished(){
		return ispublished;
	}

	public String getKetPengaduan(){
		return ketPengaduan;
	}

	public String getPelapor(){
		return pelapor;
	}

	public String getIdPengaduan(){
		return idPengaduan;
	}

	public String getPicture(){
		return picture;
	}

	public String getLokasi(){
		return lokasi;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ReportDataItem{" +
			"judul_pengaduan = '" + judulPengaduan + '\'' + 
			",respon = '" + respon + '\'' + 
			",ispublished = '" + ispublished + '\'' + 
			",ket_pengaduan = '" + ketPengaduan + '\'' + 
			",pelapor = '" + pelapor + '\'' +
			",lokasi = '" + lokasi + '\'' +
			",id_pengaduan = '" + idPengaduan + '\'' + 
			",picture = '" + picture + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}