package com.example.misdaqia.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.misdaqia.Adapters.JularyAdapter;
import com.example.misdaqia.Adapters.MainCategoriesAdapter;
import com.example.misdaqia.Helper.MainFontTextview;
import com.example.misdaqia.Model.JularyModel;
import com.example.misdaqia.Model.JularyObjectModel;
import com.example.misdaqia.R;
import com.example.misdaqia.Services.ApiClient;
import com.example.misdaqia.Services.JsonPlaceHolderApi;
import com.tripl3dev.prettystates.StateExecuterKt;
import com.tripl3dev.prettystates.StatesConstants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Jewerly extends AppCompatActivity implements JularyAdapter.ClickListener {

    private RecyclerView jularyRecyclerView;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<JularyModel>jularylist=new ArrayList<>();
    ImageView arrow_back;
    MainFontTextview txt_back;
    LinearLayoutManager linearLayoutManager;
    JularyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewerly);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        initView();
        GetJularyData();
        performOnbackPressed();
    }

    private void initView() {
        txt_back = (MainFontTextview) findViewById(R.id.txt_back);
        arrow_back = (ImageView) findViewById(R.id.arrow_back);
        jularyRecyclerView = (RecyclerView) findViewById(R.id.julary_id);
        jsonPlaceHolderApi= ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
    }

    private void GetJularyData(){
        StateExecuterKt.setState(jularyRecyclerView, StatesConstants.LOADING_STATE);
        Call<JularyObjectModel>call=jsonPlaceHolderApi.getJulary();
        call.enqueue(new Callback<JularyObjectModel>() {
            @Override
            public void onResponse(Call<JularyObjectModel> call, Response<JularyObjectModel> response) {
                if (response.isSuccessful()){
                    StateExecuterKt.setState(jularyRecyclerView, StatesConstants.NORMAL_STATE);
                    JularyObjectModel jularyObjectModel=response.body();
                    jularylist.addAll(jularyObjectModel.Data);
                    initJularyRecyclerView();
                }else {
                    StateExecuterKt.setState(jularyRecyclerView, StatesConstants.NORMAL_STATE);
                    Toast.makeText(Jewerly.this, getString(R.string.fail), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<JularyObjectModel> call, Throwable t) {
                StateExecuterKt.setState(jularyRecyclerView, StatesConstants.NORMAL_STATE);
                Toast.makeText(Jewerly.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(Jewerly.this, ""+position, Toast.LENGTH_SHORT).show();
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

    private void initJularyRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(Jewerly.this);
        jularyRecyclerView.setLayoutManager(linearLayoutManager);
        jularyRecyclerView.setItemAnimator(new DefaultItemAnimator());
        jularyRecyclerView.setNestedScrollingEnabled(false);
        jularyRecyclerView.setHasFixedSize(true);
        jularyRecyclerView.scrollToPosition(0);
        jularyRecyclerView.setNestedScrollingEnabled(false);
        adapter= new JularyAdapter(Jewerly.this, jularylist,Jewerly.this);
        jularyRecyclerView.setAdapter(adapter);
    }
}
