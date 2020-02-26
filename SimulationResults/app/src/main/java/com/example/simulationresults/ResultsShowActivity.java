package com.example.simulationresults;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import org.apache.commons.text.TextStringBuilder;

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
    private TextStringBuilder outputBuffer;

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
        Button btn = (Button) findViewById(R.id.server);
        btn.setOnClickListener(new View.OnClickListener() {
            //start execution of ssh commands
            @Override
            public void onClick(View v){
                new AsyncTask<Integer, Void, Void>(){
                    @Override
                    protected Void doInBackground(Integer... params) {
                        try {
                            SSHCommand();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }.execute(1);
            }
        });


        GridView gridView = (GridView) findViewById(R.id.gridView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, simple_list_item_1, csvLine);
        gridView.setAdapter(arrayAdapter);
    }

    public void SSHCommand(){
        String user = "cs16rrj1";
        String password = "KatEdison123";
        String host = "168.62.179.129";
        int port = 22;

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setTimeout(10000);
            session.connect();
            ChannelExec channel = (ChannelExec)session.openChannel("exec");
            channel.setCommand("ls");
            channel.connect();
            InputStream input = channel.getInputStream();
            int data = input.read();
            while(data != -1) {
                outputBuffer.append((char)data);
                data = input.read();
            }

            channel.disconnect();
            Log.e("Error problem", "Error");

            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } catch (JSchException e) {
            Toast.makeText(this, "Check Server or Wifi" + e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Navigate.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


}
