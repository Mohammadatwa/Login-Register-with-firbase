package com.example.coder_kun.internshipapplicationsoleeklab;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("rest/v2/all")
    Call <List<CountryModel>>getCountries();
}
