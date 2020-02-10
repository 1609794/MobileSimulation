package com.example.simulationresults;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static android.R.layout.simple_list_item_1;


public class ResultsShowActivity extends AppCompatActivity {
    static String TAG = "Results Page View"; //used to log items
    ArrayList<String> csvLine = new ArrayList<>();
    ListView mList;
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
        ReadDataCSV();
        mList = (ListView) findViewById(R.id.listView);
        CustomAdapter1 customAdapter = new CustomAdapter1();
       // ArrayAdapter arrayAdapter = new ArrayAdapter(this,simple_list_item_1, csvLine);
        mList.setAdapter(customAdapter);

//        TableLayout table = (TableLayout) findViewById(R.id.hello);
//ArrayList<Double> oneword = new ArrayList<>();
//oneword.add(12.0);
//oneword.add(13.0);
//oneword.add(11.0);
//
//        for (int i = 0; i < oneword.size(); i++) {
//           // Log.d(TAG, "OnCreate Name: " + csvLine.get(i));
//            TableRow row = new TableRow(this);
//            double debt = oneword.get(i);
//            TextView tvDebt = new TextView(this);
//            tvDebt.setText("" + debt);
//            row.addView(tvDebt);
//            table.addView(row);
//        }
    }

    class CustomAdapter1 extends BaseAdapter{

        @Override
        public int getCount() {
            return csvLine.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            View view2 = getLayoutInflater().inflate(R.layout.activity_main3, null);
            TextView mTextView1 = view2.findViewById(R.id.FirstText);
            TextView mTextView2 = view2.findViewById(R.id.SecondText);
            TextView mTextView3 = view2.findViewById(R.id.ThirdText);
            TextView mTextView4 = view2.findViewById(R.id.FourthText);
            mTextView1.setText(csvLine.get(position));
            mTextView2.setText(csvLine.get(position));
            mTextView3.setText(csvLine.get(position));
            mTextView4.setText(csvLine.get(position));

            return view2;
        }
    }



}
