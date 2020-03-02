package com.example.simulationresults;

import com.jcraft.jsch.UserInfo;

public class SSHUserInfo implements UserInfo {
    private final String pwd;

    public SSHUserInfo (String userName, String password) {
        pwd = password;
    }

    @Override
    public String getPassphrase() {
        throw new UnsupportedOperationException("getPassphrase Not supported yet.");
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public boolean promptPassword(String string) {
        /*mod*/
        return true;
    }

    @Override
    public boolean promptPassphrase(String string) {
        throw new UnsupportedOperationException("promptPassphrase Not supported yet.");
    }

    @Override
    public boolean promptYesNo(String string) {
        /*mod*/
        return true;
    }

    @Override
    public void showMessage (String string) {
    }

}
