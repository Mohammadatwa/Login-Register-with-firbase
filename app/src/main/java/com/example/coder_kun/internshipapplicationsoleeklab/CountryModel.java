package com.example.coder_kun.internshipapplicationsoleeklab;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CountryModel implements Serializable {

    @SerializedName("name")
    private String Country;
    @SerializedName("capital")
    private String Capital;


    public String getCountry() {
        return Country;
    }
    public String getCapital() { return Capital; }


}
