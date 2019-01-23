package com.example.s3639782.clouda2.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.example.s3639782.clouda2.R;
import com.example.s3639782.clouda2.controller.RegisterUser;


public class RegisterActivity extends AppCompatActivity {

    private EditText Username, Email,Password;
    private Button registerBtn;
    //private Toolbar mRegisterToolbar;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Email = (EditText)findViewById(R.id.email);
        Username = (EditText)findViewById(R.id.name);
        Password = (EditText) findViewById(R.id.password);
        registerBtn = (Button)findViewById(R.id.btnRegister);


       // mRegisterToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.register_toolbar);

        //setSupportActionBar(mRegisterToolbar);
        //getSupportActionBar().setTitle("Register");

        registerBtn.setOnClickListener(new RegisterUser(Email,Username,Password,context)) ;


    }
}
