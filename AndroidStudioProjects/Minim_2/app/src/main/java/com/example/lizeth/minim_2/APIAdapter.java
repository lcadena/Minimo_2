package com.example.lizeth.minim_2;

import com.example.lizeth.minim_2.APIService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class APIAdapter {
    private static APIAdapter API_SERVICE;

    private static final String baseUrl = "https://api.dsamola.tk /";
    public static APIService api;

    private APIAdapter(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(APIService.class);
    };


    public static APIAdapter getInstance(){
        if(API_SERVICE==null)
            return new APIAdapter();
        return API_SERVICE;
    }

}
