package com.example.rajaampat.model;

import com.google.gson.annotations.SerializedName;

public class ResponseCurrency{

	@SerializedName("code")
	private int code;

	@SerializedName("rates")
	private Rates rates;

	public int getCode(){
		return code;
	}

	public Rates getRates(){
		return rates;
	}

	@Override
 	public String toString(){
		return 
			"ResponseCurrency{" + 
			"code = '" + code + '\'' + 
			",rates = '" + rates + '\'' + 
			"}";
		}
}