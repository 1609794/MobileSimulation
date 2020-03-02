package com.example.simulationresults;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static String TAG = "Main Activity - Page";//used for log items

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Application Started");
        openActivity();
    }

    public void openActivity()
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent go = new Intent(MainActivity.this, Navigate.class);
                startActivity(go);
                finish();

            }
        }, 5000);
    }




}
