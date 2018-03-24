package com.example.android.musicplayer.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.data.Album;
import com.example.android.musicplayer.data.Song;


/**
 * Created by ithom on 21.03.2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView songTitle;
        TextView songDetails;
        ImageView songImage;

        public ViewHolder(View itemView) {
            super(itemView);

            songTitle = itemView.findViewById(R.id.songTitle);
            songDetails = itemView.findViewById(R.id.songDetails);
            songImage = itemView.findViewById(R.id.songImage);
        }
    }

    private Album album;

    public AlbumAdapter(Album album){
        this.album = album;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_list_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.v(AlbumAdapter.class.getSimpleName(), "POSITION " + position);
        Song song = album.getSongs().get(position);
        String songDetails = song.getArtist() + " " + song.getDuration();

        holder.songImage.setImageResource(album.getAlbumImageResId());

        holder.songTitle.setText(song.getTitle());
        holder.songDetails.setText(songDetails);
    }

    @Override
    public int getItemCount() {
        Log.v(AlbumAdapter.class.getSimpleName(), "Album SIZE "+album.getSongs().size());
        return album.getSongs().size();
    }

}
