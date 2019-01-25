package com.example.coder_kun.internshipapplicationsoleeklab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeScreenActivity extends AppCompatActivity implements View.OnClickListener {
    private Button logoutbtn;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<CountryModel> countries;
    private APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //recyclerview
            recyclerView = (RecyclerView) findViewById(R.id.countrieslistview);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
        //api request
            apiInterface = APIClient.getAPI().create(APIInterface.class);
            Call <List<CountryModel>> call = apiInterface.getCountries();
            call.enqueue(new Callback<List<CountryModel>>() {
                @Override
                public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                    countries = response.body();
                    adapter = new RecyclerAdapter(countries);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                    Toast.makeText(HomeScreenActivity.this,"Make sure you have internet connection and try again!", Toast.LENGTH_SHORT).show();
                }
            });

        //btn
            logoutbtn = (Button) findViewById(R.id.logoutbtn);
            logoutbtn.setOnClickListener(this);

    }
    private void toLogin(){
            Intent intent = new Intent(HomeScreenActivity.this, LoginActivity.class);
            startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        if (v == logoutbtn) {
            toLogin();
            finish();
        }
    }
}