package com.example.rajaampat.network;

import com.example.rajaampat.model.ResponseCurrency;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BaseCurrencyService {

    // Fungsi ini untuk memanggil API https://www.freeforexapi.com/api/live?pairs=USDIDR
    @GET("api/live/{pairs}")
    Call<ResponseCurrency> currencyRequest(@Query("pairs") String pairs);

}
