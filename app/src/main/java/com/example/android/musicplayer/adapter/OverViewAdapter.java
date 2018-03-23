package com.example.android.musicplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.android.musicplayer.R;
import com.example.android.musicplayer.activity.AlbumActivity;
import com.example.android.musicplayer.data.Album;
import com.example.android.musicplayer.helper.Config;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ithom on 20.03.2018.
 */

public class OverViewAdapter extends RecyclerView.Adapter<OverViewAdapter.ViewHolder> {

    ArrayList<Album> albums;

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
        Log.v(OverViewAdapter.class.getSimpleName(),"onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.overview_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.v(OverViewAdapter.class.getSimpleName(), albums.get(position).getAlbumName());
        final Context context = holder.itemView.getContext();
        final Album album = albums.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = createGSONFromObject(album);
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
                Toast.makeText(context, context.getString(R.string.play_clicked),Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Create JSON String from given album
     * @param album
     * @return
     */
    private String  createGSONFromObject(Album album){

        Gson gson = new Gson();
        String json =  gson.toJson(album);
        Log.v(OverViewAdapter.class.getSimpleName(), "JSON: " + json);
        return json;
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}
