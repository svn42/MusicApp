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

public class ArtistAdapter extends ArrayAdapter<Artist> {


    public ArtistAdapter(Context context, ArrayList<Artist> artists) {
        super(context, 0, artists);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_item, parent, false);
        }
        Artist local_artist = getItem(position);
        TextView artistNameTV = (TextView) listItemView.findViewById(R.id.artist_name);
        artistNameTV.setText(local_artist.getArtistName());
        TextView artistCountTV = (TextView) listItemView.findViewById(R.id.song_count);
        artistCountTV.setText("Songs: " + local_artist.getArtistCount());

        return listItemView;
    }
}
