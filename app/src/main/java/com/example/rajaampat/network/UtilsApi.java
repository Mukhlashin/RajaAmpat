package com.example.rajaampat.network;

public class UtilsApi {

    public static final String BASE_URL_API = "https://raja-ampat.dfiserver.com/";
//    public static final String BASE_CURRENCY_API = "https://www.freeforexapi.com";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }

//    public static BaseCurrencyService getCurrencyService(){
//        return RetrofitClient.getClient(BASE_CURRENCY_API).create(BaseCurrencyService.class);
//    }
}
