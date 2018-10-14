package com.pranaypathole.democrime;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class homepage extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    public void complaint(View view){
        Intent comIntent = new Intent(this, complaint.class);
        startActivity(comIntent);
    }

    public void dialSos(View view){
        Intent sosIntent = new Intent(this, sosActivity.class);
        startActivity(sosIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        mAuth = FirebaseAuth.getInstance();

        mUser = mAuth.getCurrentUser();
    }

    public void signout(View view){
        mAuth.signOut();
        finish();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.logout){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            Toast.makeText(this, "Logging Out ...", Toast.LENGTH_SHORT).show();
        }

        if(item.getItemId() == R.id.aboutdeveloper){
            Intent myIntent = new Intent(getApplicationContext(), aboutDeveloper.class);
            startActivity(myIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
