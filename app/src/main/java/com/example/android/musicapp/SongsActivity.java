package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.musicapp.R;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    SongList sl = new SongList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create a list of songs
        ArrayList<Song> songs = sl.getSongList();

        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        ImageView backButton = findViewById(R.id.backButton);


        //Intent to new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Song song = (Song) arg0.getItemAtPosition(arg2);
                String artistName = song.getSongArtist();
                String songName = song.getSongTitle();

                Intent songIntent = new Intent(SongsActivity.this, PlayingActivity.class);
                songIntent.putExtra("artist", artistName);
                songIntent.putExtra("song", songName);
                songIntent.putExtra("source", "SongsActivity");

                startActivity(songIntent);

            }
        });

        // Set a click listener on backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(SongsActivity.this, MainActivity.class);
                startActivity(backIntent);
            }
        });
    }


}
