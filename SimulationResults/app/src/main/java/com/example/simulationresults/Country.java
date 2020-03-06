package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class Country extends AppCompatActivity {
    static String TAG = "Main Activity - Page";
    private FirebaseAuth mAuth;
    private Button LogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i(TAG, "Country view Started");
        Button Mali = findViewById(R.id.Mali);
        Button Burundi = findViewById(R.id.Burundi);
        Button CAR = findViewById(R.id.CAR);
        Button SouthSudan = findViewById(R.id.SouthSudan);
        LogOut = findViewById(R.id.LogOut);
        mAuth = FirebaseAuth.getInstance();


        Mali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(Country.this, NavMali.class);
                startActivity(goToNextPage);
                finish();
            }
        });

        Burundi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(Country.this, NavBurundi.class);
                startActivity(goToNextPage);
                finish();
            }
        });

        CAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(Country.this, NavCAR.class);
                startActivity(goToNextPage);
                finish();
            }
        });

        SouthSudan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(Country.this, Navigate.class);
                startActivity(goToNextPage);
                finish();
            }
        });


        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(Country.this, LoginActivity.class));
            }
        });

    }

}
