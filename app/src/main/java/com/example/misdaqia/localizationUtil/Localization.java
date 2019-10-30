package com.example.misdaqia.localizationUtil;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;


import java.util.Locale;



public class Localization {
    public static final int arabic = 0;
    public static final int english = 1;


    public static void SetLanguage(Context context, int lang) {
        String local = "en";
        if (lang == arabic) {
            local = "ar";
        } else if (lang == english) {
            //english
            local = "en";
        }
        new UserData().saveLocalization(context, lang);
        changeLocale(context, new Locale(local), lang);
    }


    private static void changeLocale(Context context, Locale locale, int langaugeId) {
        Configuration conf = context.getResources().getConfiguration();
        conf.locale = locale;
        Locale.setDefault(locale);
        new UserData().saveLocalization(context, langaugeId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            conf.setLayoutDirection(conf.locale);
        }
        context.getResources().updateConfiguration(conf, null);
    }


    public static int getCurrentLanguageID(Context context) {
        int languageID = new UserData().getLocalization(context);
        Log.i("languageID", "" + languageID);
        return languageID;
    }


    public static int getCurrentLanguageName(Context context) {

        int lang = 0; // Default is Arabic
        if (new UserData().getLocalization(context) == arabic) {
            //arabic
            lang = Localization.arabic;
        } else {
            //english
            lang = Localization.english;
        }
        return lang;
    }


}
