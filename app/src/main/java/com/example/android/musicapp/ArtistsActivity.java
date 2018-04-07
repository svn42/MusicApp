package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {


    SongList sl = new SongList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_list);
        TextView title = findViewById(R.id.Start);
        title.setText("Artists");

        // Create a list of artists
        ArrayList<Artist> artistList = sl.getArtistList();

        ArtistAdapter adapter = new ArtistAdapter(this, artistList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        //Intent to new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Artist artist = (Artist)arg0.getItemAtPosition(arg2);
                String artistName = artist.getArtistName();

                Intent artistsIntent = new Intent(ArtistsActivity.this, SongsByArtistActivity.class);
                artistsIntent.putExtra("incoming", artistName);
                startActivity(artistsIntent);

            }
        });

    }

}
