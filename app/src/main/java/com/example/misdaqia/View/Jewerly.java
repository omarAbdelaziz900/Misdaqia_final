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

public class Jewerly extends AppCompatActivity implements JularyAdapter.ClickListener {

    private RecyclerView jularyId;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private ArrayList<JularyModel>jularylist=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewerly);
        initView();
        GetJularyData();
    }

    private void initView() {
        jularyId = (RecyclerView) findViewById(R.id.julary_id);
        jsonPlaceHolderApi= ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
    }

    private void GetJularyData(){
        jularylist.clear();

        Call<JularyObjectModel>call=jsonPlaceHolderApi.getJulary();
        call.enqueue(new Callback<JularyObjectModel>() {
            @Override
            public void onResponse(Call<JularyObjectModel> call, Response<JularyObjectModel> response) {
                if (response.isSuccessful()){

                    JularyObjectModel jularyObjectModel=response.body();
                    jularylist.addAll(jularyObjectModel.Data);
                    JularyAdapter adapter=new JularyAdapter(Jewerly.this,jularylist,Jewerly.this);
                    jularyId.setLayoutManager(new LinearLayoutManager(Jewerly.this));
                    jularyId.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(Jewerly.this, "faild", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<JularyObjectModel> call, Throwable t) {
                Toast.makeText(Jewerly.this, "Check Internet", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(Jewerly.this, ""+position, Toast.LENGTH_SHORT).show();


    }
}
