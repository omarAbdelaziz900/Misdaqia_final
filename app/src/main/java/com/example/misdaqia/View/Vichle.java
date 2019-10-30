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

import java.net.ConnectException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Vichle extends AppCompatActivity implements JularyAdapter.ClickListener {

    private RecyclerView vichleRecyclerId;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<JularyModel> vichleslist=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vichle);
        initView();
        GetVichleData();
    }

    private void initView() {
        vichleRecyclerId = (RecyclerView) findViewById(R.id.vichle_recycler_id);
        jsonPlaceHolderApi= ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
    }

    private void GetVichleData(){
        vichleslist.clear();

        Call<JularyObjectModel> call=jsonPlaceHolderApi.getVichle();
        call.enqueue(new Callback<JularyObjectModel>() {
            @Override
            public void onResponse(Call<JularyObjectModel> call, Response<JularyObjectModel> response) {
                if (response.isSuccessful()){

                    JularyObjectModel jularyObjectModel=response.body();
                    vichleslist.addAll(jularyObjectModel.Data);
                    JularyAdapter adapter=new JularyAdapter(Vichle.this,vichleslist,Vichle.this);
                    vichleRecyclerId.setLayoutManager(new LinearLayoutManager(Vichle.this));
                    vichleRecyclerId.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(Vichle.this, getString(R.string.fail), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<JularyObjectModel> call, Throwable t) {
             if (t instanceof ConnectException){
                Toast.makeText(Vichle.this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
            }
            }
        });

    }

    @Override
    public void onItemClick(int position) {

    }
}
