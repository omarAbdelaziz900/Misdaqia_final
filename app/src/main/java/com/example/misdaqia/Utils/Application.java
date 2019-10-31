package com.example.misdaqia.Utils;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.misdaqia.R;
import com.tripl3dev.prettystates.StatesConfigFactory;

public class Application extends android.app.Application {

    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        StatesConfigFactory.Companion.intialize().initDefaultViews();
        StatesConfigFactory.Companion.get().setDefaultLoadingLayout(R.layout.fragment_loader);
        StatesConfigFactory.Companion.get().setDefaultErrorLayout(R.layout.prettystates_default_error_view);

    }

    public static Application get(Context context) {
        return (Application) context.getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }

}