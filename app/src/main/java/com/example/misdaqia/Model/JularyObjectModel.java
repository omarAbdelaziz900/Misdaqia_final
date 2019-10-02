package com.example.misdaqia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JularyObjectModel {

    @SerializedName("count of rows")
    public int Counte;

    @SerializedName("data")
    @Expose
    public List<JularyModel> Data;
}
