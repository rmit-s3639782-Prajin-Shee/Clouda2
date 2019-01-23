package com.example.s3639782.clouda2.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.s3639782.clouda2.R;
import com.example.s3639782.clouda2.controller.LoginUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText loginEmail, loginPassword;
    private FirebaseAuth firebaseAuth;
    private Button LoginBtn, RegisterScrnBtn;
    private Context context = this;
    //private android.support.v7.widget.Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEmail = (EditText)findViewById(R.id.loginEmail);
        loginPassword = (EditText)findViewById(R.id.loginPassword);
        LoginBtn = (Button) findViewById(R.id.loginBtn);
        RegisterScrnBtn = (Button) findViewById(R.id.registerScreenBtn);
        //mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.login_toolbar);

       // setSupportActionBar(mToolbar);
       // getSupportActionBar().setTitle("Login");

        LoginBtn.setOnClickListener(new LoginUser(loginEmail, loginPassword, context, LoginBtn));
        RegisterScrnBtn.setOnClickListener(new LoginUser(loginEmail, loginPassword, context, LoginBtn));






    }
}
