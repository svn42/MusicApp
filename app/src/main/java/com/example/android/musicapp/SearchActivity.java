package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    SongList sl = new SongList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_list);

        Intent intent = getIntent();
        final String searchName = intent.getExtras().getString("search");

        // Create a list of songs
        ArrayList<Song> songs = sl.getSearchList(searchName);

        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        TextView title = findViewById(R.id.Start);
        ImageView backButton = findViewById(R.id.backButton);


        title.setText("Search result: " + searchName);

        //Intent to new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Song song  = (Song)arg0.getItemAtPosition(arg2);
                String artistName = song.getSongArtist();
                String songName = song.getSongTitle();

                Intent songIntent = new Intent(SearchActivity.this, PlayingActivity.class);
                songIntent.putExtra("artist", artistName);
                songIntent.putExtra("song", songName);
                songIntent.putExtra("source", "SearchActivity");
                songIntent.putExtra("search", searchName);

                startActivity(songIntent);

            }
        });

        // Set a click listener on backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(backIntent);
            }
        });
    }




}
