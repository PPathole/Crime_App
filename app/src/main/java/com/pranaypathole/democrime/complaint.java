package com.pranaypathole.democrime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class complaint extends AppCompatActivity {

    public void submitReport(View view){
        Toast.makeText(this, "Report Submitted!", Toast.LENGTH_SHORT).show();
        Intent gotoIntent = new Intent(this, homepage.class);
        startActivity(gotoIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
    }
}
