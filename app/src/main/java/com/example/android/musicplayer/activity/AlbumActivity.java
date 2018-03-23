package com.example.android.musicplayer.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.data.Album;
import com.example.android.musicplayer.fragments.AlbumFragment;
import com.example.android.musicplayer.helper.AlbumHelper;

public class AlbumActivity extends AppCompatActivity {

    FloatingActionButton playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        playButton = findViewById(R.id.floatingplayButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"play was clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Bundle bundle = getIntent().getExtras();
        setUpAlbumInfos(bundle);
        setUpFragment(bundle);
    }

    private void setUpAlbumInfos(Bundle bundle) {

        Album album = AlbumHelper.getAlbumFromJSON(bundle);
        if(album != null) {
            TextView albumName = findViewById(R.id.albumName);
            TextView albumArtist = findViewById(R.id.albumArtist);

            albumName.setText(album.getAlbumName());
            albumArtist.setText(album.getAlbumArtist());
        }
    }

    private void setUpFragment(Bundle bundle) {
        AlbumFragment albumFragment = new AlbumFragment();
        albumFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.albumViewHolder, albumFragment);
        fragmentTransaction.commit();
    }
}
