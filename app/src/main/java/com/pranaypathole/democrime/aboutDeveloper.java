package com.pranaypathole.democrime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class aboutDeveloper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);

        TextView twitter = findViewById(R.id.twitter);
        twitter.setMovementMethod(LinkMovementMethod.getInstance());
        TextView instagram = findViewById(R.id.instagram);
        instagram.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
