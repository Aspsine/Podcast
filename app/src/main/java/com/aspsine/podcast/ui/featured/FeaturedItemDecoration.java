package com.aspsine.podcast.ui.featured;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.podcast.ui.featured.item.banner.BannerViewModel;
import com.aspsine.podcast.ui.featured.item.title.TitleViewModel;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderProviderPool;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

/**
 * Created by aspsine on 16/9/17.
 */

public class FeaturedItemDecoration extends RecyclerView.ItemDecoration {

    private int mMargin;

    public FeaturedItemDecoration(int margin) {
        this.mMargin = margin;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int type = parent.getAdapter().getItemViewType(parent.getChildAdapterPosition(view));
        Class<? extends ItemViewModel> clazz = ItemViewHolderProviderPool.getItemViewModelClass(type);
        if (clazz == TitleViewModel.class) {
            outRect.set(mMargin, mMargin, mMargin, 0);
        } else if (clazz == BannerViewModel.class) {
            outRect.set(0, 0, 0, mMargin);
        }
    }

}
