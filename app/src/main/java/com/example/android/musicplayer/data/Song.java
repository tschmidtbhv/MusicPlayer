package com.example.android.musicplayer.data;

import java.text.DecimalFormat;

/**
 * Created by ithom on 20.03.2018.
 */

public class Song {

    private String title;
    private String artist;
    private float duration;
    private int songImageResId;

    public Song(String title, String artist, int duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    /*
     * Get Duration in Minutes
     */
    public String getDuration() {
        float tempDuration = duration / 60;
        return new DecimalFormat("#.##").format(tempDuration);
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getSongImageResId() {
        return songImageResId;
    }

    public void setSongImageResId(int songImageResId) {
        this.songImageResId = songImageResId;
    }
}
