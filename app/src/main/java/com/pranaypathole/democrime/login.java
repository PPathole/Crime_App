package com.pranaypathole.democrime;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText emailLogin, pwdLogin;
    TextView loginAsAdmin;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = findViewById(R.id.emailLogin);
        pwdLogin = findViewById(R.id.passwordLogin);

        loginAsAdmin = (TextView) findViewById(R.id.adminlogin);


        mAuth = FirebaseAuth.getInstance();
    }

    public void loginToHomepage(View view){

        if(emailLogin.getText().toString().equals("") && pwdLogin.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Blank Fields Not Accepted!", Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(emailLogin.getText().toString(), pwdLogin.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "User logged in Successfully!", Toast.LENGTH_SHORT).show();
                                finish();

                                Intent loginhomeIntent = new Intent(getApplicationContext(), homepage.class);
                                startActivity(loginhomeIntent);

                            }else{
                                Toast.makeText(getApplicationContext(), "User couldn't be logged it, try again!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }

    public void adminLogin(View view){

        Intent i = new Intent(getApplicationContext(), adminLogin.class);
        startActivity(i);

    }

}
