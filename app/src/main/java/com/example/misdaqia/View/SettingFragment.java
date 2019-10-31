package com.example.misdaqia.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.misdaqia.Helper.MainFontTextview;
import com.example.misdaqia.R;
import com.example.misdaqia.Services.ApiClient;
import com.example.misdaqia.Services.JsonPlaceHolderApi;
import com.example.misdaqia.localizationUtil.Localization;

public class SettingFragment extends Fragment {

    MainFontTextview arabic_txt,english_txt;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView(view);
        convertLanguage();
    }

    void bindView(View view){
        arabic_txt=view.findViewById(R.id.arabic_txt);
        english_txt=view.findViewById(R.id.english_txt);
    }


    void convertLanguage(){
        arabic_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Localization.SetLanguage(getActivity(), Localization.arabic);
                getActivity().finish();
                startActivity(getActivity().getIntent());
            }
        });

        english_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Localization.SetLanguage(getActivity(), Localization.english);
                getActivity().finish();
                startActivity(getActivity().getIntent());
            }
        });

    }
}
