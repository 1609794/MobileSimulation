package com.example.simulationresults;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static android.R.layout.simple_list_item_1;
import static android.app.PendingIntent.getActivity;


public class ResultsShowActivity extends AppCompatActivity {

    static String TAG = "Results Page View"; //used to log items
    ArrayList<String> csvLine = new ArrayList<>();
    //ListView mList;
    public ArrayList<String> ReadDataCSV() {
        String[] content = null;
        try {
            InputStream is = getAssets().open("out.csv");
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
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ReadDataCSV();
        GridView gridView = (GridView) findViewById(R.id.gridView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, simple_list_item_1, csvLine);
        gridView.setAdapter(arrayAdapter);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Navigate.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


}
