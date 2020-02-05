package com.example.simulationresults;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.R.layout.simple_list_item_1;

public class ResultsShowActivity extends AppCompatActivity {
    static String TAG = "Results Page View"; //used to log items
    ArrayList<String> csvLine = new ArrayList<>();

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
        setContentView(R.layout.resultsshow);
        ListView listView = findViewById(R.id.listView);
        ReadDataCSV();


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, simple_list_item_1, csvLine);
        listView.setAdapter(arrayAdapter);
    }
}


