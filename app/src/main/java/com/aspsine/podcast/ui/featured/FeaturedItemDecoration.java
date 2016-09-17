package com.aspsine.podcast.ui.featured;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.podcast.ui.featured.viewmodel.FeaturedItem;

/**
 * Created by aspsine on 16/9/17.
 */

public class FeaturedItemDecoration extends RecyclerView.ItemDecoration{

    private int mMargin;

    public FeaturedItemDecoration(int margin) {
        this.mMargin = margin;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int type = parent.getAdapter().getItemViewType(parent.getChildAdapterPosition(view));
        switch (type){
            case FeaturedItem.TYPE_FEATURED_TITLE:
                outRect.set(mMargin, mMargin, 0, 0);
                break;
        }
    }

}
