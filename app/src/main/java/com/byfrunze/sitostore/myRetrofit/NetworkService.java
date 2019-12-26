package com.byfrunze.sitostore.myRetrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService networkService;
    public static final String BASE_URL = "http://sito.store:8081";

    public static SitoStoreApi getApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SitoStoreApi service = retrofit.create(SitoStoreApi.class);
        return service;
    }

    public static NetworkService getInstance(){
        if(networkService == null){
            networkService = new NetworkService();
        }
        return networkService;
    }

}
