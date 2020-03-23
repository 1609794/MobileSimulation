package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    static String TAG = "Main Activity - Page";//used for log items
    public static long startTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Application Started");
        startTime = SystemClock.elapsedRealtime();
        openActivity();
    }

    public void openActivity()
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent go = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(go);
                finish();

            }
        }, 8000);
    }

    public static long getRunningTime(){
        return SystemClock.elapsedRealtime() - startTime;
    }

}
