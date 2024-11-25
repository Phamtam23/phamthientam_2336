package com.example.logrincallapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface api {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    api apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.22:5254/api/APINguoiDung/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        .create(api.class);

    @GET("getAllUsers")
    Call<List<user>> getAll();
    @GET("getHoSo")
    Call<user2> getinf(@Query("Idnguoidung") String Idnguoidung);

}
