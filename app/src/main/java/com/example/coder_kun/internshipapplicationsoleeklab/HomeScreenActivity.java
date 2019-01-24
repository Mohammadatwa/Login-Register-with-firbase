package com.example.coder_kun.internshipapplicationsoleeklab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends AppCompatActivity implements View.OnClickListener {
    private Button logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

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