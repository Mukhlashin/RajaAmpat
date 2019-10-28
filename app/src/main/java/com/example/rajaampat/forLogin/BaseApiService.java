package com.example.rajaampat.forLogin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/auth/login?
    @FormUrlEncoded
    @POST("login?")
    public Call<ResponseBody> loginRequest(@Field("email") String email, @Field("password") String password);


    // oawkawokawoaowkwako

}
