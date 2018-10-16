package com.pranaypathole.democrime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class adminLogin extends AppCompatActivity {

    EditText adminEmail;
    EditText adminPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminEmail = findViewById(R.id.adminEmail);
        adminPassword = findViewById(R.id.adminPassword);

        if(adminEmail.getText().toString().equals("admin@email.com") && adminPassword.getText().toString().equals("admin")){
            Intent i = new Intent(this, adminHome.class);
            startActivity(i);
            Toast.makeText(this, "Welcome Admin!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
