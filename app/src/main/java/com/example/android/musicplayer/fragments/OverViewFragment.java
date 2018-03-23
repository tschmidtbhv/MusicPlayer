package com.example.android.musicplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.adapter.OverViewAdapter;
import com.example.android.musicplayer.data.Album;
import com.example.android.musicplayer.helper.AlbumHelper;
import com.example.android.musicplayer.helper.Config;
import com.example.android.musicplayer.helper.ItemDecorationSpacing;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverViewFragment extends Fragment {

    ArrayList<Album> albums;

    private RecyclerView recyclerView;

    public OverViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_over_view, container, false);
        albums = AlbumHelper.createDummyData();
        setUpRecyclerView(view);

        return view;
    }


    /**
     * Setup the RecyclerView with the dummy data
     * @param view
     */
    private void setUpRecyclerView(View view) {

        Toast.makeText(getActivity(),"onActivityCreated with items: " +albums.size(), Toast.LENGTH_SHORT).show();

        recyclerView = view.findViewById(R.id.overview_recyler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), Config.NUMBEROFOVERVIWECOLUMNS));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new ItemDecorationSpacing(50));
        OverViewAdapter adapter = new OverViewAdapter(albums);
        recyclerView.setAdapter(adapter);

    }

}
