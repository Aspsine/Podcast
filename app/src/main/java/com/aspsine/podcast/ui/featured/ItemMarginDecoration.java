package com.aspsine.podcast.ui.featured;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by aspsine on 16/9/17.
 */

public class ItemMarginDecoration extends RecyclerView.ItemDecoration {

    private int mMargin;

    public ItemMarginDecoration(int margin) {
        this.mMargin = margin;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();

        int spanCount = gridLayoutManager.getSpanCount();

        int orientation = gridLayoutManager.getOrientation();

        if (orientation == GridLayoutManager.HORIZONTAL) {
            final int left;
            final int top;
            final int right;
            final int bottom;

            if (position < spanCount) {
                left = mMargin;
                right = mMargin / 2;
            } else if (position > parent.getAdapter().getItemCount() - spanCount - 1) {
                left = mMargin / 2;
                right = mMargin;
            } else {
                left = mMargin / 2;
                right = mMargin / 2;
            }
            top = mMargin;
            bottom = mMargin;

            outRect.set(left, top, right, bottom);
        } else {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }
}
