package com.example.android.musicapp;

/**
 * Created by Sven on 03.04.2018.
 */

public class Artist {

    private String mArtistName;

    private int mArtistCount;

    public Artist(String artistName, int artistCount) {
        mArtistName = artistName;
        mArtistCount = artistCount;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public int getArtistCount() {
        return mArtistCount;
    }

    public void addArtistCount() {
        mArtistCount += 1;
    }
}
