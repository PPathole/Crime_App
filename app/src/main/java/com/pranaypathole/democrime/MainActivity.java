package com.pranaypathole.democrime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void loginUser(View view){
        Intent loginuserIntent = new Intent(this, login.class);
        startActivity(loginuserIntent);
    }

    public void registerUser(View view){
        Intent registeruserIntent = new Intent(this, register.class);
        startActivity(registeruserIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
