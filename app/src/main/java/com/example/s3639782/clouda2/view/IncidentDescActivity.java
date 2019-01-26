package com.example.s3639782.clouda2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.s3639782.clouda2.R;

public class IncidentDescActivity extends AppCompatActivity {

    private EditText incName, incDesc;
    private Button incReportbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_desc);


        incName = (EditText)findViewById(R.id.incName);
        incDesc = (EditText)findViewById(R.id.incDesc);
        incReportbtn = (Button)findViewById(R.id.incReportBtn);

        incReportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(IncidentDescActivity.this, MapsActivity.class );
                i.putExtra("incName", incName.getText().toString());
                i.putExtra("incDesc", incDesc.getText().toString());

                startActivity(i);

            }
        });



    }
}
