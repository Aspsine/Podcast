package com.aspsine.podcast.ui.main.featured;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.podcast.ui.main.featured.item.banner.BannerViewModel;
import com.aspsine.podcast.ui.main.featured.item.title.TitleViewModel;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;
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
        final int position = parent.getChildAdapterPosition(view);
        final ItemViewAdapter<? extends ItemViewModel> adapter = (ItemViewAdapter<? extends ItemViewModel>) parent.getAdapter();
        final int type = adapter.getItemViewType(position);
        final Class<? extends ItemViewModel> clazz = adapter.getItemViewModelClass(type);
        if (clazz == TitleViewModel.class) {
            outRect.set(mMargin, mMargin, mMargin, 0);
        } else if (clazz == BannerViewModel.class) {
            outRect.set(0, 0, 0, mMargin);
        }
    }

}
