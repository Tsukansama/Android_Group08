package com.example.cainiaoguo.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.3.8:80")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static Retrofit retrofitNoObject = new Retrofit.Builder()
            .baseUrl("http://192.168.3.8:80")
            .build();

    public static Retrofit getRetrofitNoJson(){
        return retrofitNoObject;
    }

    public static Retrofit getRetrofit(){
        return retrofit;
    }
}
