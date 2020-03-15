package com.example.simulationresults;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView info;
    private TextView Register;
    private TextView forgotPassword;
    private int Counter = 5;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    FirebaseAuth.AuthStateListener mAuthListener;
    static String TAG = "Login Activity - Page";//used for log items
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG, "Login page Started");
        Name = (EditText) findViewById(R.id.name);
        Password = (EditText) findViewById(R.id.password);
        info = (TextView) findViewById(R.id.attempts);
        Login = (Button) findViewById(R.id.btnlogin);
        Register = (TextView) findViewById(R.id.register);
        forgotPassword = (TextView) findViewById(R.id.forgetPassword);

        info.setText("No of attempts remaining: 5");
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
                    startActivity(intent);
                    finish();
                }
            }};

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation(Name.getText().toString(), Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, PasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validation(String userName, String userPassword){
       progressDialog.setMessage("Please wait....");
       progressDialog.show();

        mAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    checkVerification();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    Counter--;
                    info.setText("No of attempts remaining: " + Counter);
                    progressDialog.dismiss();
                    if(Counter == 0){
                        Login.setEnabled(false);
                    }
                }
            }
        });


}

    private void checkVerification(){
        FirebaseUser user = mAuth.getInstance().getCurrentUser();
        Boolean emailCheck = user.isEmailVerified();

        if(emailCheck){
            finish();
            startActivity(new Intent(LoginActivity.this, MapsActivity.class));
        }
        else{
            Toast.makeText(this, "Need to Verify email address", Toast.LENGTH_SHORT).show();
            mAuth.signOut();
        }
    }
    @Override
    public void onBackPressed(){

    }

}