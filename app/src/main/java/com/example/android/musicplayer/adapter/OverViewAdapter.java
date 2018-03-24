package com.example.android.musicplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.activity.AlbumActivity;
import com.example.android.musicplayer.data.Album;
import com.example.android.musicplayer.helper.AlbumHelper;
import com.example.android.musicplayer.helper.Config;

import java.util.ArrayList;

/**
 * Created by ithom on 20.03.2018.
 */

public class OverViewAdapter extends RecyclerView.Adapter<OverViewAdapter.ViewHolder> {

    ArrayList<Album> albums;
    OnAlbumSelectedListener albumSelectedListener;

    public interface OnAlbumSelectedListener {
        public void onAlbumSelected(Album album);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;
        private Button playButton;

        private ViewHolder(View viewItem) {
            super(viewItem);
            title = viewItem.findViewById(R.id.albumName);
            image = viewItem.findViewById(R.id.albumImage);
            playButton = viewItem.findViewById(R.id.playButton);
        }
    }

    public OverViewAdapter(ArrayList<Album> albums) {
        this.albums = albums;
    }

    @Override
    public OverViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.overview_item, parent, false);
        albumSelectedListener = (OnAlbumSelectedListener) parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Context context = holder.itemView.getContext();
        final Album album = albums.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = AlbumHelper.createGSONFromObject(album);
                Intent intent = new Intent(context, AlbumActivity.class);
                intent.putExtra(Config.ALBUM, json);
                context.startActivity(intent);
            }
        });
        holder.title.setText(album.getAlbumName());
        holder.image.setImageResource(album.getAlbumImageResId());
        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, context.getString(R.string.play_clicked), Toast.LENGTH_SHORT).show();
                albumSelectedListener.onAlbumSelected(album);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}
