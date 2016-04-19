package com.example.m14x.volleyrecyclerview_itunes.Model;

/**
 * Created by m14x on 04/18/2016.
 */
public class Pojo {

    private String artistName = null;
    private String collectionName = null;
    private String trackName = null;

    public Pojo(String artistName, String collectionName, String trackName) {

        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "artistName='" + artistName + '\'' +
                ", collectionName='" + collectionName + '\'' +
                ", trackName='" + trackName + '\'' +
                '}';
    }

    public Pojo(){

    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

}
