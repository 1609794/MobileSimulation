package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NavBurundi extends AppCompatActivity {
    static String TAG = "Main Activity - Page";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_burundi);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        Log.i(TAG, "Navigation view Started");
        Button table = findViewById(R.id.tableBurundi);
       // Button graph = findViewById(R.id.GraphBurundi);
        Button btn = findViewById(R.id.serverBurundi);

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(NavBurundi.this, ResultsBurundi.class);
                startActivity(goToNextPage);
                finish();
            }
        });

//        graph.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent goToNextPage = new Intent(NavBurundi.this, Graphview.class);
//                startActivity(goToNextPage);
//                finish();
//            }
//        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(NavBurundi.this, SSH.class);
                startActivity(goToNextPage);
                finish();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Country.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

}
