package com.example.android.musicapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Sven on 03.04.2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {


    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }
        Song local_song = getItem(position);
        TextView songTitleTV = (TextView) listItemView.findViewById(R.id.song_title);
        songTitleTV.setText(local_song.getSongTitle());
        TextView songArtistTV = (TextView) listItemView.findViewById(R.id.song_artist);
        songArtistTV.setText(local_song.getSongArtist());

        return listItemView;
    }

}
