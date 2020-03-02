package com.example.simulationresults;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SSH extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssh);
         btn = (Button) findViewById(R.id.server);
        new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... params) {
                try {
                    SSHReadFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute(1);

    }

    public static void SSHReadFile()throws Exception{
        String hostname = "168.62.179.129";
        String username = "cs16rrj1";
        String password = "KatEdison123";
        String command = "cd /home/cs16rrj1/business\ncat sales.txt\nexit\n";
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(username, hostname, 22);
            session.setUserInfo(new SSHUserInfo(username, password));
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            Channel channel = session.openChannel("shell");
            channel.setInputStream(new ByteArrayInputStream(command.getBytes(StandardCharsets.UTF_8)));
            channel.setOutputStream(System.out);
            InputStream in = channel.getInputStream();
            StringBuilder outBuff = new StringBuilder();
            int exitStatus = -1;

            channel.connect();

            while (true) {
                for (int c; ((c = in.read()) >= 0);) {
                    outBuff.append((char) c);
                }

                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    exitStatus = channel.getExitStatus();
                    break;
                }
            }
            channel.disconnect();
            session.disconnect();

            System.out.print (outBuff.toString());

            System.out.print ("Exit status of the execution: " + exitStatus);
            if ( exitStatus == 0 ) {
                System.out.print (" (OK)\n");
            } else {
                System.out.print (" (NOK)\n");
            }
        }
        catch (IOException | JSchException ioEx) {
            System.err.println(ioEx.toString());
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Navigate.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}


