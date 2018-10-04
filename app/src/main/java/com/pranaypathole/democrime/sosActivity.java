package com.pranaypathole.democrime;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class sosActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
    }

    public void dialPolice(View view){
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:100"));
        startActivity(i);
    }

    public void playmorse(View view){
        MediaPlayer mplayer = MediaPlayer.create(this, R.raw.morsecode);
        mplayer.start();
    }


    public void contact(View view){
        Intent callintent = new Intent(Intent.ACTION_DIAL);
        startActivity(callintent);
    }
}
