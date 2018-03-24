package com.example.android.musicplayer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.adapter.OverViewAdapter;
import com.example.android.musicplayer.data.Album;
import com.example.android.musicplayer.fragments.OverViewFragment;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;


public class MainActivity extends AppCompatActivity implements SlidingUpPanelLayout.PanelSlideListener , OverViewAdapter.OnAlbumSelectedListener{

    SlidingUpPanelLayout slidingUpPanelLayout;
    Button topPlayButton;
    Button miniPlayButton;
    Button previousButton;
    Button nextButton;

    boolean isPlaying = false;

    private TextView songTitle;
    private ImageView songImage;

    private View.OnClickListener playOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changePlayState();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpLayout();
    }

    /**
     * Change the playState for
     * PlayButtons
     */
    private void changePlayState() {
        if (isPlaying) {
            isPlaying = false;
            int imgResource = android.R.drawable.ic_media_play;
            topPlayButton.setBackgroundResource(imgResource);
            miniPlayButton.setBackgroundResource(imgResource);
        } else {
            isPlaying = true;
            int imgResource = android.R.drawable.ic_media_pause;
            topPlayButton.setBackgroundResource(imgResource);
            miniPlayButton.setBackgroundResource(imgResource);
        }
    }

    private void setUpLayout() {
        setReferences();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment overViewFragment = new OverViewFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewHolder, overViewFragment);
        fragmentTransaction.commit();

        setUpListeners();
        slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
    }


    /**
     * Initial Listener Setup
     */
    private void setUpListeners() {

        slidingUpPanelLayout.addPanelSlideListener(this);
        topPlayButton.setOnClickListener(playOnClickListener);
        miniPlayButton.setOnClickListener(playOnClickListener);
    }

    /**
     * Initial References Setup
     */
    private void setReferences() {

        slidingUpPanelLayout = findViewById(R.id.sliding_layout);
        topPlayButton = findViewById(R.id.topPlayButton);
        miniPlayButton =  findViewById(R.id.miniPlayButton);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        songTitle = findViewById(R.id.miniplayerSongtitle);
        songImage = findViewById(R.id.miniplayerImage);
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        //Unused in my case. But needed because of the implementation from PanelSlideListener
    }

    @Override
    public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

        if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
            topPlayButton.setVisibility(View.GONE);
        } else if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
            topPlayButton.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Album was selected
     * Play the album
     * @param album
     */
    @Override
    public void onAlbumSelected(Album album) {
        if(!isPlaying) {
            changePlayState();
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        }
        songTitle.setText(album.getAlbumName());
        songImage.setImageResource(album.getAlbumImageResId());
    }
}
