package com.example.android.musicplayer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.fragments.OverViewFragment;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;


public class MainActivity extends AppCompatActivity implements SlidingUpPanelLayout.PanelSlideListener {

    SlidingUpPanelLayout slidingUpPanelLayout;
    Button topPlayButton;
    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment overViewFragment = new OverViewFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewHolder, overViewFragment);
        fragmentTransaction.commit();

        slidingUpPanelLayout = findViewById(R.id.sliding_layout);
        slidingUpPanelLayout.addPanelSlideListener(this);

        topPlayButton = findViewById(R.id.topplaybutton);
        topPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    isPlaying = false;
                    topPlayButton.setBackgroundResource(android.R.drawable.ic_media_play);
                } else {
                    isPlaying = true;
                    topPlayButton.setBackgroundResource(android.R.drawable.ic_media_pause);
                }
            }
        });
    }


    @Override
    public void onPanelSlide(View panel, float slideOffset) {

    }

    @Override
    public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

        if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
            Log.v(MainActivity.class.getSimpleName(), "open");
            topPlayButton.setVisibility(View.GONE);
        } else if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
            Log.v(MainActivity.class.getSimpleName(), "close");
            topPlayButton.setVisibility(View.VISIBLE);
        }
    }
}
