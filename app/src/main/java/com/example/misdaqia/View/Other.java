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

public class Other extends AppCompatActivity implements JularyAdapter.ClickListener {

    private RecyclerView otherRecyclerId;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    ArrayList<JularyModel>otherlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initView();
        GetOtherData();
    }

    private void initView() {
        otherRecyclerId = (RecyclerView) findViewById(R.id.other_recycler_id);
        jsonPlaceHolderApi= ApiClient.getApiClient().create(JsonPlaceHolderApi.class);
    }

    private void GetOtherData(){
        otherlist.clear();

        Call<JularyObjectModel> call=jsonPlaceHolderApi.getOther();
        call.enqueue(new Callback<JularyObjectModel>() {
            @Override
            public void onResponse(Call<JularyObjectModel> call, Response<JularyObjectModel> response) {
                if (response.isSuccessful()){

                    JularyObjectModel jularyObjectModel=response.body();
                    otherlist.addAll(jularyObjectModel.Data);
                    JularyAdapter adapter=new JularyAdapter(Other.this,otherlist,Other.this);
                    otherRecyclerId.setLayoutManager(new LinearLayoutManager(Other.this));
                    otherRecyclerId.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(Other.this, "faild", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<JularyObjectModel> call, Throwable t) {
                Toast.makeText(Other.this, "Check Internet", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onItemClick(int position) {

    }
}
