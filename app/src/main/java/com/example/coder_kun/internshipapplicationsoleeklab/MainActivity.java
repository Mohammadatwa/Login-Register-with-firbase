package com.example.coder_kun.internshipapplicationsoleeklab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button regbtn;
    private Button logbtn;
    private EditText emailtext;
    private EditText pwtext;
    private EditText context;
    private ProgressDialog proglog;

    private FirebaseAuth fireauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proglog = new ProgressDialog(this);
        fireauth = FirebaseAuth.getInstance();

        regbtn = (Button) findViewById(R.id.regbtn);
        logbtn = (Button) findViewById(R.id.logbtn);
        emailtext = (EditText) findViewById(R.id.emailtext);
        pwtext = (EditText) findViewById(R.id.pwtext);
        context = (EditText) findViewById(R.id.context);

        regbtn.setOnClickListener(this);
        logbtn.setOnClickListener(this);
    }

        private void registerUser () {
            String email = emailtext.getText().toString().trim();
            String pw = pwtext.getText().toString().trim();
            String con = context.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(pw)) {
                Toast.makeText(this, "please enter a password", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(con)) {
                Toast.makeText(this, "please confirm password", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!pw.equals(con)) {
                Toast.makeText(this,"password doesn't match", Toast.LENGTH_SHORT).show();
                return;
            }
            proglog.setMessage("Loading..");
            proglog.show();

            fireauth.createUserWithEmailAndPassword(email,pw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    proglog.dismiss();
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Registration Complete", Toast.LENGTH_SHORT).show();

                        finish();
                        Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
                        startActivity(intent);

                    }
                    else { Toast.makeText(MainActivity.this,"Registration Failed, please try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    public void toLog()
    {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == regbtn) {

            registerUser ();
        }
        if (v == logbtn) {
            toLog ();
            finish();
        }
    }

}
