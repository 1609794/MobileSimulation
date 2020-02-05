package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Navigate extends AppCompatActivity {
    static String TAG = "Main Activity - Page";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i(TAG, "Navigation view Started");
        Button table = findViewById(R.id.table);
        Button graph = findViewById(R.id.Graph);

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
                Intent goToNextPage = new Intent(Navigate.this, Graphview2.class);
                startActivity(goToNextPage);
                finish();
            }
        });
    }

}
