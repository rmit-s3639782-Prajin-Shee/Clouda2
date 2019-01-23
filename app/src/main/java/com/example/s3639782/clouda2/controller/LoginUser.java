package com.example.s3639782.clouda2.controller;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.s3639782.clouda2.R;
import com.example.s3639782.clouda2.view.MapsActivity;
import com.example.s3639782.clouda2.view.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginUser implements View.OnClickListener {
    private EditText loginEmail, loginPassword;
    private Button button;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;

    Context context;

    public LoginUser(EditText loginEmail, EditText loginPassword, Context context, Button button){
        this.loginEmail=loginEmail;
        this.loginPassword=loginPassword;
        this.context=context;
        this.button=button;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.loginBtn:
                verifyUser();
                break;
            case R.id.registerScreenBtn:
                Intent i = new Intent(context, RegisterActivity.class);
                context.startActivity(i);
                break;

        }
    }

    public void verifyUser(){
        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        final ProgressDialog progressDialog = ProgressDialog
                .show(context, "Please wait...", "Processing...", true);
        firebaseAuth.signInWithEmailAndPassword(loginEmail.getText().toString(),loginPassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Toast.makeText(context, "Login Successful",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(context, MapsActivity.class);
                            context.startActivity(i);
                        }
                        else{
                            Log.e("Error", task.getException().toString());
                            Toast.makeText(context, task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }


}
