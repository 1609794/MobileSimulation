//package com.example.simulationresults;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelExec;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.Session;
//import com.jcraft.jsch.*;
//import com.jcraft.jsch.ChannelSftp.LsEntry;
//import java.io.InputStream;
//import java.util.Properties;
//
///**
// * Created by DAT on 03/12/2017.
// */
//
//public class Config extends AppCompatActivity {
//
//public void SSH() {
//    try {
//        JSch ssh = new JSch();
//        Session session = ssh.getSession("username", "myip90000.ordomain.com", 22);
//        // Remember that this is just for testing and we need a quick access, you can add an identity and known_hosts file to prevent
//        // Man In the Middle attacks
//        java.util.Properties config = new java.util.Properties();
//        config.put("StrictHostKeyChecking", "no");
//        session.setConfig(config);
//        session.setPassword("Passw0rd");
//        session.connect();
//
//        Channel channel = session.openChannel("sftp");
//        channel.connect();
//
//        ChannelSftp sftp = (ChannelSftp) channel;
//
//        // Now that we have a channel, go to a directory first if we want .. you can give to the ls the path
//        // sftp.cd("/var/www/mydirectory");
//
//        @SuppressWarnings("unchecked")
//
//        // Get the content of the actual path using ls instruction or use the previous string of the cd instruction
//                java.util.Vector<LsEntry> flLst = sftp.ls("/var/www/mydirectory");
//
//        final int i = flLst.size();
//
//        // show the info of every folder/file in the console
//        for (int j = 0; j < i; j++) {
//            LsEntry entry = flLst.get(j);
//            SftpATTRS attr = entry.getAttrs();
//
//            System.out.println(entry.getFilename());
//            System.out.println(directory + "/" + entry.getFilename()); // Remote filepath
//            System.out.println("isDir", attr.isDir()); // Is folder
//            System.out.println("isLink", attr.isLink()); // is link
//            System.out.println("size", attr.getSize()); // get size in bytes of the file
//            System.out.println("permissions", attr.getPermissions()); // permissions
//            System.out.println("permissions_string", attr.getPermissionsString());
//            System.out.println("longname", entry.toString());
//
//
//        }
//
//        channel.disconnect();
//        session.disconnect();
//    } catch (JSchException e) {
//        System.out.println(e.getMessage().toString());
//        e.printStackTrace();
//    } catch (SftpException e) {
//        System.out.println(e.getMessage().toString());
//        e.printStackTrace();
//    }
//}}