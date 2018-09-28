package com.pranaypathole.democrime;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel: 100"));
        startActivity(dialIntent);
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
}
