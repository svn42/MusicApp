package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        Intent intent = getIntent();
        String artistIntent = intent.getExtras().getString("artist");
        String titleIntent = intent.getExtras().getString("song");

        TextView title = findViewById(R.id.currentlyPlayingSong);
        TextView artist = findViewById(R.id.currentlyPlayingArtist);

        title.setText(titleIntent);
        artist.setText(artistIntent);

    }

}
