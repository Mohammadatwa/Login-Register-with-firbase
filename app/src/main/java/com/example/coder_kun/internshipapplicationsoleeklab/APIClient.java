package com.example.coder_kun.internshipapplicationsoleeklab;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASE_URL = "https://restcountries.eu/";
    public static Retrofit retrofit = null;

    public static Retrofit getAPI (){
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
