package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class NavBurundi extends AppCompatActivity {

    static String TAG = "Main Activity - Page";
    private FirebaseAuth mAuth;
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
        mAuth = FirebaseAuth.getInstance();
        Button logout = findViewById(R.id.LogOut);


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


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(NavBurundi.this, LoginActivity.class));
                MainActivity timer = new MainActivity();
                System.out.println( "RUNNING TIME " + timer.getRunningTime());
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
