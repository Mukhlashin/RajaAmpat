package com.example.rajaampat.model;

import com.google.gson.annotations.SerializedName;

public class NewsDataItem {

	@SerializedName("artikel_id")
	private String artikelId;

	@SerializedName("judul_artikel")
	private String judulArtikel;

	@SerializedName("ispublished")
	private String ispublished;

	@SerializedName("picture")
	private String picture;

	@SerializedName("detil_artikel")
	private String detilArtikel;

	public String getArtikelId(){
		return artikelId;
	}

	public String getJudulArtikel(){
		return judulArtikel;
	}

	public String getIspublished(){
		return ispublished;
	}

	public String getPicture(){
		return picture;
	}

	public String getDetilArtikel(){
		return detilArtikel;
	}

	@Override
 	public String toString(){
		return 
			"NewsDataItem{" +
			"artikel_id = '" + artikelId + '\'' + 
			",judul_artikel = '" + judulArtikel + '\'' + 
			",ispublished = '" + ispublished + '\'' + 
			",picture = '" + picture + '\'' + 
			",detil_artikel = '" + detilArtikel + '\'' + 
			"}";
		}
}