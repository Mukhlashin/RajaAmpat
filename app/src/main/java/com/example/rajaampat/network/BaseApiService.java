package com.example.rajaampat.network;

import com.example.rajaampat.model.ResponseUser;

import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BaseApiService {

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/auth/login.php
    @FormUrlEncoded
    @POST("api/auth/login")
    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    Call<ResponseUser> loginRequest(@Field("api_auth_key") String apiKey,
                                    @Field("email") String email,
                                    @Field("pwd") String password);

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/users
    @GET("api/users/{user_id}")
    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    Call<ResponseUser> singleUserRequest(@Field("api_auth_key") String apiKey,
                                         @Query("user_id") String userId);

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/register.php
    @FormUrlEncoded
    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    @POST("api/users/register")
    Call<ResponseUser> registerRequest(@Field("api_auth_key") String apiKey,
                                       @Field("user_name") String nama,
                                       @Field("email") String email,
                                       @Field("pwd") String password);

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/users/update.php

    @FormUrlEncoded
    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    @POST("api/users/update")
    Call<ResponseUser> updateRequest(@Field("api_auth_key") String apiKey,
                                     @Field("user_name") String user_name,
                                     @Field("nama") String nama,
                                     @Field("email") String email,
                                     @Field("pwd") String password);
}