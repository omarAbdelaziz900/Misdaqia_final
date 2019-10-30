package com.example.misdaqia.localizationUtil;


import android.content.Context;

import com.example.misdaqia.SharedPreferences.SharedPreferencesTool;


public class UserData {

    public String TAG_LOCALIZATION = "localization";





    public void saveLocalization(Context context, int value) {
        SharedPreferencesTool.setInt(context, TAG_LOCALIZATION, value);
    }

    public int getLocalization(Context context) {
        return SharedPreferencesTool.getInt(context, TAG_LOCALIZATION);
    }

}
