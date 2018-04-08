package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        Intent intent = getIntent();
        final String artistIntent = intent.getExtras().getString("artist");
        final String titleIntent = intent.getExtras().getString("song");
        final String sourceIntent = intent.getExtras().getString("source");
        final String sourceSearch = intent.getExtras().getString("search");


        TextView title = findViewById(R.id.currentlyPlayingSong);
        TextView artist = findViewById(R.id.currentlyPlayingArtist);
        ImageView backButton = findViewById(R.id.backButton);


        title.setText(titleIntent);
        artist.setText(artistIntent);

        // Set a click listener on backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {

                switch (sourceIntent) {
                    case "SongsActivity":
                        Intent backSongsIntent = new Intent(PlayingActivity.this, SongsActivity.class);
                        startActivity(backSongsIntent);
                        break;
                    case "SearchActivity":
                        Intent backSearchIntent = new Intent(PlayingActivity.this, SearchActivity.class);
                        backSearchIntent.putExtra("search", sourceSearch);
                        startActivity(backSearchIntent);
                        break;
                    case "SongsByArtistActivity":
                        Intent backSongsByArtistIntent = new Intent(PlayingActivity.this, SongsByArtistActivity.class);
                        backSongsByArtistIntent.putExtra("incoming", artistIntent);
                        startActivity(backSongsByArtistIntent);
                        break;
                }
            }
        });
    }

}
