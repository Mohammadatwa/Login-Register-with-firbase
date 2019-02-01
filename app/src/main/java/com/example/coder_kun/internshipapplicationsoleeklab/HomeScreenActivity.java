package com.example.coder_kun.internshipapplicationsoleeklab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeScreenActivity extends AppCompatActivity implements View.OnClickListener {
    private Button logoutbtn;
    private Button showListBtn;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<CountryModel> countries;
    private APIInterface apiInterface;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        progressDialog = new ProgressDialog(this);
        //recyclerview
        recyclerView = (RecyclerView) findViewById(R.id.countrieslistview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //api request
        apiInterface = APIClient.getAPI().create(APIInterface.class);
        Call <List<CountryModel>> call = apiInterface.getCountries();
        progressDialog.show();
        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                countries = response.body();
//                    adapter = new RecyclerAdapter(countries);
//                    recyclerView.setAdapter(adapter);
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(HomeScreenActivity.this,"Make sure you have internet connection and try again!", Toast.LENGTH_SHORT).show();
            }
        });

        //btn
        logoutbtn = (Button) findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(this);
        showListBtn = (Button) findViewById(R.id.listbtnid);
        showListBtn.setOnClickListener(this);

    }
    private void toLogin(){
        Intent intent = new Intent(HomeScreenActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    private void toShowList(){
        Intent intent = new Intent(HomeScreenActivity.this, MyListActivity.class);
        intent.putExtra("countryModelList", (Serializable) countries);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        if (v == logoutbtn) {
            toLogin();
            finish();
        }
        if (v == showListBtn) {
            toShowList();
            finish();
        }
    }
}