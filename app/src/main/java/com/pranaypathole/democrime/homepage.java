package com.pranaypathole.democrime;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homepage extends AppCompatActivity {

    public void complaint(View view){
        Intent comIntent = new Intent(this, complaint.class);
        startActivity(comIntent);
    }

    public void dialSos(View view){
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel: 9923411165"));
        startActivity(dialIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }
}
