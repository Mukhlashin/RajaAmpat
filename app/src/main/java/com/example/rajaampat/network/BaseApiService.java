package com.example.rajaampat.network;

import com.example.rajaampat.model.DataItem;
import com.example.rajaampat.model.NewsDataItem;
import com.example.rajaampat.model.ResponseHotel;
import com.example.rajaampat.model.ResponseNews;
import com.example.rajaampat.model.ResponseSingleUser;
import com.example.rajaampat.model.ResponseUser;
import com.example.rajaampat.model.modelReport.ResponseReport;
import com.example.rajaampat.model.modelReport.ResponseTravel;

import java.io.File;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface BaseApiService {

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/auth/login.php
    @FormUrlEncoded
    @POST("api/auth/login")
    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    Call<ResponseUser> loginRequest(@Field("api_auth_key") String apiKey,
                                    @Field("email") String email,
                                    @Field("pwd") String password);

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/users/id
    @GET("api/users/{id}")
    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    Call<ResponseSingleUser> singleUserRequest(@Query("id") String userId);

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/register.php
    @FormUrlEncoded
    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    @POST("api/users/register")
    Call<ResponseUser> registerRequest(@Field("api_auth_key") String apiKey,
                                       @Field("user_name") String nama,
                                       @Field("email") String email,
                                       @Field("pwd") String password,
                                       @Field("tgl_lahir") String tglLahir);

    // Fungsi ini untuk memanggil API https://raja-ampat.dfiserver.com/api/users/update.php
    @FormUrlEncoded
    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    @POST("api/users/update")
    Call<ResponseUser> updateRequest(@Field("id") String userId,
                                     @Field("user_name") String user_name,
                                     @Field("no_ktp") String noKTP,
                                     @Field("tgl_lahir") String TanggalLahir,
                                     @Field("tempat_lahir") String tempatLahir,
                                     @Field("alamat") String alamat,
                                     @Field("email") String email,
                                     @Field("pwd") String password);

    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    @GET("api/pengaduan")
    Call<ResponseReport> reportRequest();

//    @FormUrlEncoded
//    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
//    @POST("api/pengaduan/create")
//    Call<ResponseReport> createReportRequest(@Field("judul_pengaduan") String judulPengaduan,
//                                             @Field("ket_pengaduan") String keteranganPengaduan,
//                                             @Field("pelapor") String pelapor,
//                                             @Field("status") String status,
//                                             @Field("picture") File picture);

    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    @GET("api/artikel")
    Call<ResponseNews> newsRequest();

    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    @GET("api/hotel")
    Call<ResponseHotel> hotelRequest();

    @Headers("api_auth_key: s0g84k84g8kc0kw44k8sgs408kc00kgs0g404koc")
    @GET("api/travel")
    Call<ResponseTravel> travelRequest();
}