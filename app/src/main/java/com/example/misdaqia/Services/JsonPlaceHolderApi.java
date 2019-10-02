package com.example.misdaqia.Services;

import com.example.misdaqia.Model.JularyObjectModel;
import com.example.misdaqia.Model.LoginUserResponse;
import com.example.misdaqia.Model.MainCategory;
import com.example.misdaqia.Model.MainCategoryResponse;
import com.example.misdaqia.Model.registerUserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {


    @FormUrlEncoded
    @POST("register")
    Call<registerUserResponse> createUser(
            @Field("name") String Name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("c_password") String re_password);

    @FormUrlEncoded
    @POST("login")
    Call<LoginUserResponse> Login(@FieldMap Map<String,String> fields);

    @GET("getCategoryApi ")
    Call<MainCategoryResponse> getCategories();

    @GET("getMazadApi")
    Call<MainCategoryResponse> getMazadat();

    @GET("getJewelryApi ")
    Call<JularyObjectModel> getJulary();

    @GET("getVichleApi ")
    Call<JularyObjectModel> getVichle();

    @GET("getcarApi ")
    Call<JularyObjectModel> getCars();

    @GET("getpropApi ")
    Call<JularyObjectModel> getBuildings();

    @GET("getHighValueApi ")
    Call<JularyObjectModel> getOther();

}