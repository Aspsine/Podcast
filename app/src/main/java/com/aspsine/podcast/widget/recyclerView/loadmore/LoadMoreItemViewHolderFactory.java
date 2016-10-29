package com.aspsine.podcast.widget.recyclerView.loadmore;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderFactory;

/**
 * Created by aspsine on 16/10/22.
 */

public class LoadMoreItemViewHolderFactory implements ItemViewHolderFactory<LoadMoreItemViewHolder> {

    @Override
    public LoadMoreItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LoadMoreItemView loadMoreView = new LoadMoreItemView(parent.getContext());
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        loadMoreView.setLayoutParams(layoutParams);
        return new LoadMoreItemViewHolder(loadMoreView);
    }
}
