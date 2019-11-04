package com.example.rajaampat.network;

public class UtilsApi {

    public static final String BASE_URL_API = "https://raja-ampat.dfiserver.com/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
