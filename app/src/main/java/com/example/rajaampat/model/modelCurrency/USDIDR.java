package com.example.rajaampat.model.modelCurrency;

import com.google.gson.annotations.SerializedName;

public class USDIDR{

	@SerializedName("rate")
	private double rate;

	@SerializedName("timestamp")
	private int timestamp;

	public double getRate(){
		return rate;
	}

	public int getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"USDIDR{" + 
			"rate = '" + rate + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}