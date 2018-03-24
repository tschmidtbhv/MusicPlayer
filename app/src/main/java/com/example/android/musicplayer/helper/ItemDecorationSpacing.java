package com.example.android.musicplayer.helper;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ithom on 21.03.2018.
 */

public class ItemDecorationSpacing extends RecyclerView.ItemDecoration {

    int spacing;

    public ItemDecorationSpacing(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        outRect.bottom = spacing;
        outRect.left = spacing;

        int currentPosition = parent.getChildLayoutPosition(view);

        if(currentPosition == 0 || currentPosition == 1){
            outRect.top = spacing;
        }

        if((currentPosition % 2) != 0){
            outRect.right = spacing;
        }


    }
}
