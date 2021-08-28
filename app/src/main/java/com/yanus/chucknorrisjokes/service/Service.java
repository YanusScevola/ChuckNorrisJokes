package com.yanus.chucknorrisjokes.service;

import com.yanus.chucknorrisjokes.utils.Credentials;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);

    public static RetrofitApi getRetrofitApi(){
        return retrofitApi;
    }
}

