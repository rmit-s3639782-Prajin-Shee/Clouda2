package com.example.s3639782.clouda2.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.s3639782.clouda2.R;
import com.example.s3639782.clouda2.model.User;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileSetupActivity extends AppCompatActivity {

    private PlaceAutocompleteFragment placeAutoComplete;
    private EditText age, phone;
    private Button profileSetupBtn;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;
    private User currentUser;
    private LatLng latLng;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);

        age = (EditText)findViewById(R.id.age);
        phone = (EditText)findViewById(R.id.phone);
        profileSetupBtn = (Button)findViewById(R.id.profileSetupBtn);



        placeAutoComplete = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete);
        placeAutoComplete.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                Log.d("Maps", "Place selected: " + place.getName());
                latLng = place.getLatLng();

            }

            @Override
            public void onError(Status status) {
                Log.d("Maps", "An error occurred: " + status);
            }
        });


        profileSetupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ProfileSetupActivity.this, MapsActivity.class);
                startActivity(i);

                firebaseAuth = FirebaseAuth.getInstance();
                mDatabase = FirebaseDatabase.getInstance().getReference();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();
                mDatabase.child("users").child(uid).child("age").setValue(age.getText().toString());
                mDatabase.child("users").child(uid).child("phone").setValue(phone.getText().toString());
                mDatabase.child("users").child(uid).child("location").setValue(latLng.toString());
            }
        });





    }
}
