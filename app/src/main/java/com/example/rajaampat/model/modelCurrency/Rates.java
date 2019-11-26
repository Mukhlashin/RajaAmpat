package com.example.rajaampat.model.modelCurrency;

import com.example.rajaampat.model.modelCurrency.USDIDR;
import com.google.gson.annotations.SerializedName;

public class Rates{

	@SerializedName("USDIDR")
	private USDIDR uSDIDR;

	public String getUSDIDR(){
		return String.valueOf(uSDIDR);
	}

	@Override
 	public String toString(){
		return 
			"Rates{" + 
			"uSDIDR = '" + uSDIDR + '\'' + 
			"}";
		}
}