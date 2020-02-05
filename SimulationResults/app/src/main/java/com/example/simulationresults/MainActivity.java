package com.example.simulationresults;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static String TAG = "Main Activity - Page";//used for log items
    static int nextPage = Config.defaultStartPage;//used to store the page to go to after delay
    static int splashTimeOut = Config.welcomePageSplashTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Application Started");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToNextPage = new Intent(MainActivity.this, Navigate.class);
                startActivity(goToNextPage);
                finish();
            }
        }, splashTimeOut);


    }




}
