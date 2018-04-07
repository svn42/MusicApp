package com.example.android.musicapp;
import java.util.ArrayList;

/**
 * Created by Sven on 06.04.2018.
 */

public class SongList {

    private ArrayList<Song> songs = new ArrayList<Song>();

    public SongList() {
        fillArray();
    }

    // Create a list of songs
    private void fillArray() {
        //Queen
        songs.add(new Song("Bohemian Rhapsody", "Queen"));
        songs.add(new Song("We are the Champions", "Queen"));
        //Michael Jackson
        songs.add(new Song("Smooth Criminal", "Michael Jackson"));
        songs.add(new Song("Billie Jean", "Michael Jackson"));
        songs.add(new Song("Beat It", "Michael Jackson"));
        songs.add(new Song("P.Y.T (Pretty Young Thing)", "Michael Jackson"));
        songs.add(new Song("Black or White", "Michael Jackson"));
        songs.add(new Song("Rock with You", "Michael Jackson"));
        songs.add(new Song("The Way You Make Me Feel", "Michael Jackson"));
        songs.add(new Song("Thriller", "Michael Jackson"));
        songs.add(new Song("Dangerous", "Michael Jackson"));
        //Phil Collins
        songs.add(new Song("You Can't Hurry Love", "Phil Collins"));
        songs.add(new Song("In The Air Tonight", "Phil Collins"));
        songs.add(new Song("You'll Be In My Heart", "Phil Collins"));
        songs.add(new Song("Against All Odds", "Phil Collins"));
        songs.add(new Song("Easy Lover", "Phil Collins"));
        songs.add(new Song("Sussudio", "Phil Collins"));
        //Meat Loaf
        songs.add(new Song("Paradise By the Dashboard Light", "Meat Loaf"));
        songs.add(new Song("Bat Out of Hell", "Meat Loaf"));
        songs.add(new Song("I'd Do Anything For Love (But I Won't Do That)", "Meat Loaf"));
        songs.add(new Song("Two Out Of Three Ain't Bad", "Meat Loaf"));
        songs.add(new Song("You Took The Words Right Out Of My Mouth (Hot Summer Night)", "Meat Loaf"));
        songs.add(new Song("Hot Patootie", "Meat Loaf"));
        songs.add(new Song("For Crying Out Loud", "Meat Loaf"));
        songs.add(new Song("Heaven Can Wait", "Meat Loaf"));
        songs.add(new Song("Dead Ringer For Love", "Meat Loaf"));
        songs.add(new Song("More", "Meat Loaf"));
        songs.add(new Song("All Of Me", "Meat Loaf"));
        songs.add(new Song("Bad For Good", "Meat Loaf"));
        //Tenacious D
        songs.add(new Song("Tribute", "Tenacious D"));
        songs.add(new Song("Beelzeboss (The Final Showdown)", "Tenacious D"));
        songs.add(new Song("The Metal", "Tenacious D"));
        songs.add(new Song("Kickapoo", "Tenacious D"));
        songs.add(new Song("Fuck Her Gently", "Tenacious D"));
        songs.add(new Song("Classico", "Tenacious D"));
        songs.add(new Song("Master Exploder", "Tenacious D"));
        songs.add(new Song("Rize of the Fenix", "Tenacious D"));
        songs.add(new Song("Roadie", "Tenacious D"));
        songs.add(new Song("Dude (I Totally Miss You)", "Tenacious D"));
        //Avenged Sevenfold
        songs.add(new Song("Nightmare", "Avenged Sevenfold"));
        songs.add(new Song("Afterlife", "Avenged Sevenfold"));
        songs.add(new Song("Buried Alive", "Avenged Sevenfold"));
        songs.add(new Song("A Little Peace of Heaven", "Avenged Sevenfold"));
        //Trivium
        songs.add(new Song("Kiristue Gomen", "Trivium"));
        songs.add(new Song("In Waves", "Trivium"));
        //Hans Zimmer
        songs.add(new Song("Time", "Hans Zimmer"));
        //Backstreet Boys
        songs.add(new Song("I Want It That Way", "Backstreet Boys"));
        //Britney
        songs.add(new Song("Toxic", "Britney Spears"));
        songs.add(new Song("Oops!...I Did It Again", "Britney Spears"));
        //Aguilera
        songs.add(new Song("Beautiful", "Christina Aguilera"));
        //Banfi
        songs.add(new Song("Future", "Banfi"));
        songs.add(new Song("June", "Banfi"));
        songs.add(new Song("Never Really Cared", "Banfi"));
        songs.add(new Song("Caroline", "Banfi"));
    }

    public ArrayList<Song> getSongList() {
        return songs;
    }



    public ArrayList<Artist> getArtistList() {

        ArrayList<Artist> artistsList = new ArrayList<Artist>();
        artistsList.add(new Artist(songs.get(0).getSongArtist(), 1));

        //every artist  of the songList ist compared to the artistList
        for (int i = 1; i < songs.size(); i++) {
            boolean foundArtist = false;
            for (int j = 0; j < artistsList.size(); j++) {
                //if the artist is already in the artist list, the method addArtistCount is called
                if (songs.get(i).getSongArtist().equals(artistsList.get(j).getArtistName())) {
                    artistsList.get(j).addArtistCount();
                    foundArtist = true;
                    break;
                }
            }
            //if the artist is not found in the artist list, a new Artist is constructed
            if (!foundArtist) {
                artistsList.add(new Artist(songs.get(i).getSongArtist(), 1));
            }
        }
        return artistsList;
    }

    //shows a list of the different Songs of a specific artist
    public ArrayList<Song> getSongListByArtist(String artist) {
        ArrayList<Song> songsArtist = new ArrayList<Song>();

        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongArtist().equals(artist)) {
                songsArtist.add(songs.get(i));
            }
        }
        return songsArtist;
    }

    //compares the search input with the songList and returns a list, of Songs which contain the searchInput
    public ArrayList<Song> getSearchList(String searchInput) {
        ArrayList<Song> searchList = new ArrayList<Song>();
        //LowerCase for the contains Method
        String searchInputLowerCase = searchInput.toLowerCase();

        for (int i = 0; i < songs.size(); i++) {
            String songArtistLowerCase = songs.get(i).getSongArtist().toLowerCase();
            String songTitleLowerCase = songs.get(i).getSongTitle().toLowerCase();
            //Compare Search Input with Artist and Song title. If theres a match, the Object ist added to the SearchList
            if (songArtistLowerCase.contains(searchInputLowerCase) || songTitleLowerCase.contains(searchInputLowerCase)) {
                searchList.add(songs.get(i));
            }
        }
        return searchList;
    }

}
