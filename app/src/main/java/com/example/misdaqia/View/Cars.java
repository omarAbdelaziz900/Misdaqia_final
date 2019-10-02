package com.example.misdaqia.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.misdaqia.Adapters.JularyAdapter;
import com.example.misdaqia.Model.JularyModel;
import com.example.misdaqia.Model.JularyObjectModel;
import com.example.misdaqia.R;
import com.example.misdaqia.Services.ApiClient;
import com.example.misdaqia.Services.JsonPlaceHolderApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cars extends AppCompatActivity implements JularyAdapter.ClickListener {

    private RecyclerView vichleRecyclerId;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<JularyModel> carslist=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        initView();
        GetVichleData();
    }

    private void initView() {
        vichleRecyclerId = (RecyclerView) findViewById(R.id.vichle_recycler_id);
        jsonPlaceHolderApi= ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
    }
    private void GetVichleData(){
        carslist.clear();

        Call<JularyObjectModel> call=jsonPlaceHolderApi.getCars();
        call.enqueue(new Callback<JularyObjectModel>() {
            @Override
            public void onResponse(Call<JularyObjectModel> call, Response<JularyObjectModel> response) {
                if (response.isSuccessful()){

                    JularyObjectModel jularyObjectModel=response.body();
                    carslist.addAll(jularyObjectModel.Data);
                    JularyAdapter adapter=new JularyAdapter(Cars.this,carslist,Cars.this);
                    vichleRecyclerId.setLayoutManager(new LinearLayoutManager(Cars.this));
                    vichleRecyclerId.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(Cars.this, "faild", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<JularyObjectModel> call, Throwable t) {
                Toast.makeText(Cars.this, "Check Internet", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onItemClick(int position) {

    }

}
