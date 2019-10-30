package com.example.misdaqia.SharedPreferences;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;


public class SharedPreferencesTool {
    public static final String TAG_FILE_NAME = "com.example.misdaqia";



    public static SharedPreferences.Editor getEditor(Context context) {

        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(TAG_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static void saveObject(Context context, String key, Object myObject) {
        SharedPreferences.Editor editor = getEditor(context);
        Gson gson = new Gson();
        String json = gson.toJson(myObject);
        editor.putString(key, json);
        editor.commit();
    }

    public static <M> M getObject(Context context, String key, Class<M> className) {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        String json = sharedPreferences.getString(key, "");
        return gson.fromJson(json, className);
    }

    public static void setBoolean(Context context, boolean remmberMe, String key) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(key, remmberMe);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return  sharedPreferences.getBoolean(key, false);
    }
    public static String getString(Context context, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(key,"");
    }

    public static void setString(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getInt(key, -1);
    }



    public static void setInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(key, value);
        editor.apply();
    }

    public static void clearObject(Context context) {
        SharedPreferences settings = context.getSharedPreferences(TAG_FILE_NAME, Context.MODE_PRIVATE);
        settings.edit().clear().apply();
    }


    public static String getFirstRun(Context context, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(key,"");
    }

    public static void setFirstRun(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.apply();
    }


    public static String getFromCurrent(Context context, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(key,"");
    }

    public static void setFromCurrent(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.apply();
    }

    public static String getFromSpinner(Context context, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(key,"");
    }

    public static void setFromSpinner(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.apply();
    }
}

