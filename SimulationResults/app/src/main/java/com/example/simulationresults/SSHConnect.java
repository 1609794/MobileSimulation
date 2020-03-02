package com.example.simulationresults;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SSHConnect {
    private Button btn;

    protected void onCreate(Bundle savedInstanceState) {
         btn = (Button) btn.findViewById(R.id.server);
        btn.setOnClickListener(new View.OnClickListener() {
            //start execution of ssh commands
            @Override
            public void onClick(View v) {
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
        });
    }

    public void SSHReadFile(){
        String user = "cs16rrj1";
        String password = "KatEdison123";
        String host = "168.62.179.129";
        int port = 22;
        String remoteFile = "/home/cs16rrj1/business/sales.txt";

        try {
            JSch jSch = new JSch();
            Session session = jSch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            Log.d("hello", "Establishing connection");
            session.connect();
            Log.d("hello", "Connection Established");
            Log.d("hello", "Creating SFTP channel");
            ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
            sftp.connect();
            Log.d("hello", "SFTP Channel created");
            InputStream inputStream = sftp.get(remoteFile);
            try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    Log.d("hello", line);
                }
            }
        } catch(JSchException | SftpException e){
            e.printStackTrace();
        }
    }
}
