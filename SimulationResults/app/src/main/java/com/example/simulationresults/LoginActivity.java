package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    static String TAG = "Login Activity - Page";//used for log items
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG, "Login page Started");
        LoginButton();
    }

    public void LoginButton(){
        Name = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.login);
        Button Register = (Button) findViewById(R.id.register);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Name.getText().toString().equals("admin") && Password.getText().toString().equals("123")){
                    Toast.makeText(LoginActivity.this, "Username and password is correct", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, Navigate.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Username and Password is incorrect", Toast.LENGTH_SHORT).show();
                    Login.setEnabled(false);
                }
            }
        });
    }
}
