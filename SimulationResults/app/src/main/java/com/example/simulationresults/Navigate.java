package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class Navigate extends AppCompatActivity {
    static String TAG = "Main Activity - Page";
    private FirebaseAuth mAuth;
    private Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i(TAG, "Navigation view Started");
        Button table = findViewById(R.id.table);
        Button graph = findViewById(R.id.Graph);
        logOut = (Button) findViewById(R.id.LogOut);
        Button btn = findViewById(R.id.server);

        mAuth = FirebaseAuth.getInstance();

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(Navigate.this, ResultsShowActivity.class);
                startActivity(goToNextPage);
                finish();
            }
        });

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(Navigate.this, Graphview.class);
                startActivity(goToNextPage);
                finish();
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(Navigate.this, LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(Navigate.this, SSH.class);
                startActivity(goToNextPage);
                finish();
            }
        });
    }

}
