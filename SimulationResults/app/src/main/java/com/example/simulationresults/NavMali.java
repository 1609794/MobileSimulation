package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NavMali extends AppCompatActivity {
    static String TAG = "Main Activity - Page";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_mali);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        Log.i(TAG, "Navigation view Started");
        Button table = findViewById(R.id.tableMali);
        Button btn = findViewById(R.id.serverMali);

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(NavMali.this, ResultsMali.class);
                startActivity(goToNextPage);
                finish();
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToNextPage = new Intent(NavMali.this, SSH.class);
                startActivity(goToNextPage);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed(){

    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

}
