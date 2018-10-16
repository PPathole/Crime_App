package com.pranaypathole.democrime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    }

    public void loginAdmin(View view){
        if(adminEmail.getText().toString().equals("admin@email.com") && adminPassword.getText().toString().equals("admin")){
            Intent adminhome = new Intent(getApplicationContext(), adminHome.class);
            startActivity(adminhome);
            Toast.makeText(this, "Welcome admin", Toast.LENGTH_SHORT).show();
        }else if(adminEmail.getText().toString().equals("")){
            Toast.makeText(this, "Blank Email Field not Allowed", Toast.LENGTH_SHORT).show();
        }else if(adminPassword.getText().toString().equals("")){
            Toast.makeText(this, "Enter password!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Blank fields not allowed!", Toast.LENGTH_SHORT).show();
        }
    }
}
