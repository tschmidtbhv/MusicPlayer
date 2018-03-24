package com.example.android.musicplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.data.Album;
import com.example.android.musicplayer.data.Song;


/**
 * Created by ithom on 21.03.2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView songTitle;
        TextView songDetails;
        ImageView songImage;

        private ViewHolder(View itemView) {
            super(itemView);

            songTitle = itemView.findViewById(R.id.songTitle);
            songDetails = itemView.findViewById(R.id.songDetails);
            songImage = itemView.findViewById(R.id.songImage);
        }
    }

    private Album album;

    public AlbumAdapter(Album album) {
        this.album = album;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Song song = album.getSongs().get(position);
        final Context context = holder.itemView.getContext();
        String songDetails = song.getArtist() + " " + song.getDuration();


        holder.songImage.setImageResource(album.getAlbumImageResId());
        holder.songTitle.setText(song.getTitle());
        holder.songDetails.setText(songDetails);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, context.getString(R.string.now_playing, song.getTitle()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return album.getSongs().size();
    }

}
