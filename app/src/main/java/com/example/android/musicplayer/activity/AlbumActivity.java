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

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            final Album album = AlbumHelper.getAlbumFromJSON(bundle);
            playButton = findViewById(R.id.floatingplayButton);
            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), getString(R.string.now_playing_album, album.getAlbumName()), Toast.LENGTH_SHORT).show();
                }
            });

            setUpAlbumInfos(album);
            setUpFragment(bundle);
        }
    }

    /**
     * Setup Album Infos
     * @param album
     */
    private void setUpAlbumInfos(Album album) {

        if (album != null) {
            TextView albumName = findViewById(R.id.albumName);
            TextView albumArtist = findViewById(R.id.albumArtist);

            albumName.setText(album.getAlbumName());
            albumArtist.setText(album.getAlbumArtist());
        }
    }

    /**
     * Initial Fragment Setup
     *
     * @param bundle contains album as a JSON String
     */
    private void setUpFragment(Bundle bundle) {
        AlbumFragment albumFragment = new AlbumFragment();
        albumFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.albumViewHolder, albumFragment);
        fragmentTransaction.commit();
    }
}
