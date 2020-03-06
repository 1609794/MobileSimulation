package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static android.R.layout.simple_list_item_1;

public class CAR extends AppCompatActivity {
    static String TAG = "Results Page View"; //used to log items
    ArrayList<String> csvLine = new ArrayList<>();

    public ArrayList<String> ReadDataCSV() {
        String[] content = null;
        try {
            InputStream is = getAssets().open("outCAR.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content = line.split(",");
                csvLine.addAll(Arrays.asList(content));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvLine;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carlayout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ReadDataCSV();

        GridView gridView = (GridView) findViewById(R.id.gridView3);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, simple_list_item_1, csvLine);
        gridView.setAdapter(arrayAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), NavCAR.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


}
