package com.example.coder_kun.internshipapplicationsoleeklab;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("name")
    private String Country;
    @SerializedName("capital")
    private String Capital;


    public String getCountry() {
        return Country;
    }
    public String getCapital() {
        return Capital;
    }
}
