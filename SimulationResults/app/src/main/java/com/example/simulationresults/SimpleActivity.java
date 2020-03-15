//package com.example.simulationresults;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//
//public class SimpleActivity extends Activity {
//
//    private static final String TAG = "Chilkat";
//
//    // Called when the activity is first created.
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // This example requires the Chilkat API to have been previously unlocked.
//        // See Global Unlock Sample for sample code.
//
//        CkSsh ssh = new CkSsh();
//
//        // Connect to an SSH server:
//        String hostname;
//        int port;
//
//        // Hostname may be an IP address or hostname:
//        hostname = "www.some-ssh-server.com";
//        port = 22;
//
//        boolean success = ssh.Connect(hostname,port);
//        if (success != true) {
//            Log.i(TAG, ssh.lastErrorText());
//            return;
//        }
//
//        // Wait a max of 5 seconds when reading responses..
//        ssh.put_IdleTimeoutMs(5000);
//
//        // Authenticate using login/password:
//        success = ssh.AuthenticatePw("myLogin","myPassword");
//        if (success != true) {
//            Log.i(TAG, ssh.lastErrorText());
//            return;
//        }
//
//        // Once the SSH object is connected and authenticated, we use it
//        // as the underlying transport in our SCP object.
//        CkScp scp = new CkScp();
//
//        success = scp.UseSsh(ssh);
//        if (success != true) {
//            Log.i(TAG, scp.lastErrorText());
//            return;
//        }
//
//        String remotePath = "test.txt";
//        String localPath = "/home/bob/test.txt";
//        success = scp.UploadFile(localPath,remotePath);
//        if (success != true) {
//            Log.i(TAG, scp.lastErrorText());
//            return;
//        }
//
//        Log.i(TAG, "SCP upload file success.");
//
//        // Disconnect
//        ssh.Disconnect();
//
//    }
//
//    static {
//        System.loadLibrary("chilkat");
//
//        // Note: If the incorrect library name is passed to System.loadLibrary,
//        // then you will see the following error message at application startup:
//        //"The application <your-application-name> has stopped unexpectedly. Please try again."
//    }
//}