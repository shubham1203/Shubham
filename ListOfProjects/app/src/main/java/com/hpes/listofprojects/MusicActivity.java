package com.hpes.listofprojects;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        b1 = (Button)findViewById(R.id.buttPlay);
        b2 = (Button)findViewById(R.id.buttStop);
        i = new Intent(this,MusicService.class);

    }
    public void play(View v){
        startService(i);
    }
    public void stop(View v){
        stopService(i);
    }
}
