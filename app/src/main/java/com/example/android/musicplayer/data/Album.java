package com.example.android.musicplayer.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ithom on 21.03.2018.
 */

public class Album {

    @SerializedName("albumName")
    String albumName;

    @SerializedName("albumArtist")
    String albumArtist;

    @SerializedName("albumImageResId")
    int albumImageResId;

    @SerializedName("songs")
    ArrayList<Song> songs;

    public Album(String album, String albumArtist, int albumImageResId, ArrayList<Song> songs){
        this.albumName = album;
        this.albumArtist = albumArtist;
        this.albumImageResId = albumImageResId;
        this.songs = songs;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public int getAlbumImageResId() {
        return albumImageResId;
    }

    public void setAlbumImageResId(int albumImageResId) {
        this.albumImageResId = albumImageResId;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", albumImageResId=" + albumImageResId +
                ", songs=" + songs +
                '}';
    }
}
