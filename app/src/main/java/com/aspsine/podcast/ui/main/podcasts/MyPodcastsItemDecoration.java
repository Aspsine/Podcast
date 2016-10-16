package com.aspsine.podcast.ui.main.podcasts;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zhangfan10 on 16/9/30.
 */

public class MyPodcastsItemDecoration extends RecyclerView.ItemDecoration {

    private int mMargin;

    public MyPodcastsItemDecoration(int margin) {
        this.mMargin = margin;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int position = parent.getChildAdapterPosition(view);
        if (position == 0) {
            outRect.set(mMargin, mMargin, mMargin, mMargin / 2);
        } else if (position == parent.getAdapter().getItemCount() - 1) {
            outRect.set(mMargin, mMargin / 2, mMargin, mMargin);
        } else {
            outRect.set(mMargin, mMargin / 2, mMargin, mMargin / 2);
        }

    }
}
