package com.pranaypathole.democrime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class register extends AppCompatActivity {

    public void registerToLogin(View view){
        Intent registerLoginIntent = new Intent(this, login.class);
        startActivity(registerLoginIntent);
        Toast.makeText(this, "Login here!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
