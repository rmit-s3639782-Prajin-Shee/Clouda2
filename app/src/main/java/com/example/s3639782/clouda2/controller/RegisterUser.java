package com.example.s3639782.clouda2.controller;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.s3639782.clouda2.model.User;
import com.example.s3639782.clouda2.view.MainActivity;
import com.example.s3639782.clouda2.view.ProfileSetupActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser implements View.OnClickListener{
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;

    EditText Email,Password, Name;
    Context context;



    public RegisterUser(EditText Email, EditText Name, EditText Password, Context context){
        this.Email = Email;
       this.Password = Password;
        this.Name = Name;
        this.context = context;

    }


    @Override
    public void onClick(View view) {

        RegisterNewUser();
    }

    public void RegisterNewUser(){

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Log.e("Email", Email.getText().toString());
        final ProgressDialog progressDialog = ProgressDialog
                .show(context,"Please wait...","Processing...", true);
        firebaseAuth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Toast.makeText(context,"Registration Successful", Toast.LENGTH_SHORT).show();

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            String uid = user.getUid();

                            User newUser = new User();
                            newUser.setmEmail(Email.getText().toString());
                            newUser.setmUUID(uid);

                            mDatabase.child("users").child(uid).child("name").setValue(Name.getText().toString());
                            mDatabase.child("users").child(uid).child("email").setValue(Email.getText().toString());

                            Intent i = new Intent(context.getApplicationContext(), ProfileSetupActivity.class);
                            context.startActivity(i);
                        }
                        else{
                            Log.e("Error", task.getException().toString());
                            Toast.makeText(context.getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }
}
