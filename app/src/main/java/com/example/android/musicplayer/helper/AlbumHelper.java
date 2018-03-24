package com.example.android.musicplayer.helper;

import android.os.Bundle;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.data.Album;
import com.example.android.musicplayer.data.Song;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by ithom on 23.03.2018.
 */

public class AlbumHelper {

    /**
     * Get the Album obj from bundle
     * @param bunde contains album as a JSONString
     * @return Album
     */
    public final static Album getAlbumFromJSON(Bundle bunde) {
        String json = bunde.getString(Config.ALBUM);

        Album album = null;

        if (json != null) {
            Gson gson = new Gson();
            album = gson.fromJson(json, Album.class);
        }

        return album;
    }

    /**
     * Create JSON String from given album
     *
     * @param album
     * @return
     */
    public final static String createGSONFromObject(Album album) {

        Gson gson = new Gson();
        String json = gson.toJson(album);
        return json;
    }

    /**
     * Create some Album Dummy Data
     */
    public final static ArrayList<Album> createDummyData() {

        ArrayList<Album> albums = new ArrayList<>();
        ArrayList<Song> songArrayList = new ArrayList<>();

        int albumNr = 0; //Internal Number for image 1-3
        for (int i = 1; i <= 20; i++) {

            for (int y = 1; y <= 20; y++) {
                if (songArrayList != null && songArrayList.size() >= 20) break;
                Song song = new Song("Songtitle " + y, "Artist " + y, 260);
                songArrayList.add(song);
            }

            int imageId = R.drawable.album_1;
            if ((albumNr % 2) != 0) {
                imageId = R.drawable.album_2;
            } else if ((albumNr % 3) != 0) {
                imageId = R.drawable.album_3;
            }

            albumNr++;

            if (albumNr >= 3) albumNr = 0;

            Album album = new Album("Album " + i, "Artist " + i, imageId, songArrayList);
            album.setSongs(songArrayList);
            albums.add(album);
        }

        return albums;
    }
}
