package com.example.android.musicplayer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.adapter.AlbumAdapter;
import com.example.android.musicplayer.data.Album;
import com.example.android.musicplayer.helper.AlbumHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumFragment extends Fragment {

    Album album;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album, container, false);

        album = AlbumHelper.getAlbumFromJSON(getArguments());
        setUpRecylerView(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView imageView = getActivity().findViewById(R.id.albumImage);
        imageView.setImageResource(album.getAlbumImageResId());
    }

    /**
     * Initial Setup for RecyclerView
     * @param view
     */
    private void setUpRecylerView(View view) {

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView = view.findViewById(R.id.albumRecycler);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        AlbumAdapter adapter = new AlbumAdapter(album);
        recyclerView.setAdapter(adapter);
    }
}
