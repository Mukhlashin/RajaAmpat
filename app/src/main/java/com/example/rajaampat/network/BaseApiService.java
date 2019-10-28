package com.example.rajaampat.network;

import com.example.rajaampat.model.ResponseUser;

import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BaseApiService {

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/auth/login.php
    @FormUrlEncoded
    @POST("api/auth/login")
    Call<ResponseUser> loginRequest(@Field("api_auth_key") String apiKey,
                                    @Field("email") String email,
                                    @Field("pwd") String password);

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/register.php

    @FormUrlEncoded
    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    @POST("api/register.php")
    Call<ResponseUser> registerRequest(@Field("api_auth_key") String apiKey,
                                       @Field("user_name") String nama,
                                       @Field("email") String email,
                                       @Field("pwd") String password);
}