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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cars extends AppCompatActivity implements JularyAdapter.ClickListener {

    private RecyclerView carsRecyclerView;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<JularyModel> carslist=new ArrayList<>();
    ImageView arrow_back;
    MainFontTextview txt_back;
    LinearLayoutManager linearLayoutManager;
    JularyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        initView();
        GetVichleData();
        performOnbackPressed();
    }

    private void initView() {
        txt_back = (MainFontTextview) findViewById(R.id.txt_back);
        arrow_back = (ImageView) findViewById(R.id.arrow_back);
        carsRecyclerView = (RecyclerView) findViewById(R.id.vichle_recycler_id);
        jsonPlaceHolderApi= ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
    }
    private void GetVichleData(){
        StateExecuterKt.setState(carsRecyclerView, StatesConstants.LOADING_STATE);
        Call<JularyObjectModel> call=jsonPlaceHolderApi.getCars();
        call.enqueue(new Callback<JularyObjectModel>() {
            @Override
            public void onResponse(Call<JularyObjectModel> call, Response<JularyObjectModel> response) {
                if (response.isSuccessful()){

                    JularyObjectModel jularyObjectModel=response.body();
                    carslist.addAll(jularyObjectModel.Data);
                    initCarsRecyclerView();
                }else {
                    Toast.makeText(Cars.this, getString(R.string.fail), Toast.LENGTH_SHORT).show();
                }

                StateExecuterKt.setState(carsRecyclerView, StatesConstants.NORMAL_STATE);
            }

            @Override
            public void onFailure(Call<JularyObjectModel> call, Throwable t) {
                StateExecuterKt.setState(carsRecyclerView, StatesConstants.NORMAL_STATE);
                Toast.makeText(Cars.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();

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

    private void initCarsRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(Cars.this);
        carsRecyclerView.setLayoutManager(linearLayoutManager);
        carsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        carsRecyclerView.setNestedScrollingEnabled(false);
        carsRecyclerView.setHasFixedSize(true);
        carsRecyclerView.scrollToPosition(0);
        carsRecyclerView.setNestedScrollingEnabled(false);
        adapter= new JularyAdapter(Cars.this, carslist,Cars.this);
        carsRecyclerView.setAdapter(adapter);
    }
}
