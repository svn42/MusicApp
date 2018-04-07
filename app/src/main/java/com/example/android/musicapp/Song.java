package com.example.android.musicapp;

/**
 * Created by Sven on 03.04.2018.
 */

public class Song {

    private String mSongTitle;

    private String mSongArtist;

    public Song (String songTitle, String songArtist){
        mSongTitle = songTitle;
        mSongArtist = songArtist;
    }

    public String getSongTitle () {
        return mSongTitle;
    }

    public String getSongArtist () {
        return mSongArtist;
    }

}
