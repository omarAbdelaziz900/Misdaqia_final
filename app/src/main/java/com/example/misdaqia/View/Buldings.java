package com.example.misdaqia.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.misdaqia.Adapters.JularyAdapter;
import com.example.misdaqia.Helper.MainFontTextview;
import com.example.misdaqia.Model.JularyModel;
import com.example.misdaqia.Model.JularyObjectModel;
import com.example.misdaqia.R;
import com.example.misdaqia.Services.ApiClient;
import com.example.misdaqia.Services.JsonPlaceHolderApi;
import com.tripl3dev.prettystates.StateExecuterKt;
import com.tripl3dev.prettystates.StatesConstants;

import java.net.ConnectException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Buldings extends AppCompatActivity implements JularyAdapter.ClickListener {

    private RecyclerView buldingRecyclerView;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<JularyModel> buldingslist=new ArrayList<>();
    ImageView arrow_back;
    MainFontTextview txt_back;
    JularyAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buldings);
        initView();
        GetBuldingsData();
        performOnbackPressed();
    }

    private void initView() {
        txt_back = (MainFontTextview) findViewById(R.id.txt_back);
        arrow_back = (ImageView) findViewById(R.id.arrow_back);
        buldingRecyclerView = (RecyclerView) findViewById(R.id.bulding_recycler_id);
        jsonPlaceHolderApi= ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
    }

    private void GetBuldingsData(){
        StateExecuterKt.setState(buldingRecyclerView, StatesConstants.LOADING_STATE);
        Call<JularyObjectModel> call=jsonPlaceHolderApi.getBuildings();
        call.enqueue(new Callback<JularyObjectModel>() {
            @Override
            public void onResponse(Call<JularyObjectModel> call, Response<JularyObjectModel> response) {
                if (response.isSuccessful()){

                    JularyObjectModel jularyObjectModel=response.body();
                    buldingslist.addAll(jularyObjectModel.Data);
                    initBuildingRecyclerView();
                }else {
                    Toast.makeText(Buldings.this, getString(R.string.fail), Toast.LENGTH_SHORT).show();
                }
                StateExecuterKt.setState(buldingRecyclerView, StatesConstants.NORMAL_STATE);
            }

            @Override
            public void onFailure(Call<JularyObjectModel> call, Throwable t) {
                if (t instanceof ConnectException) {
                    Toast.makeText(Buldings.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                }

                StateExecuterKt.setState(buldingRecyclerView, StatesConstants.NORMAL_STATE);
            }
        });

    }

    @Override
    public void onItemClick(int position) {

    }

    void performOnbackPressed(){
        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        txt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initBuildingRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(Buldings.this);
        buldingRecyclerView.setLayoutManager(linearLayoutManager);
        buldingRecyclerView.setItemAnimator(new DefaultItemAnimator());
        buldingRecyclerView.setNestedScrollingEnabled(false);
        buldingRecyclerView.setHasFixedSize(true);
        buldingRecyclerView.scrollToPosition(0);
        buldingRecyclerView.setNestedScrollingEnabled(false);
        adapter= new JularyAdapter(Buldings.this, buldingslist,Buldings.this);
        buldingRecyclerView.setAdapter(adapter);
    }
}
