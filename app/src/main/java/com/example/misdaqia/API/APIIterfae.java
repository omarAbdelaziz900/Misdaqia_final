package com.example.misdaqia.API;


import java.util.ArrayList;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIIterfae {
    String BaseUrl="https://mesdaqia2.000webhostapp.com/api/";
    @GET("getpropApi/")
    Call<ArrayList<Datum>> method();



}
