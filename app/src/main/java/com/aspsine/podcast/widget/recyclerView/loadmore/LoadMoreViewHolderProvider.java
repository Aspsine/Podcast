package com.aspsine.podcast.widget.recyclerView.loadmore;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.aspsine.podcast.util.DisplayUtil;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderProvider;

/**
 * Created by aspsine on 16/10/22.
 */

public class LoadMoreViewHolderProvider implements ItemViewHolderProvider<LoadMoreViewHolder> {

    @Override
    public LoadMoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LoadMoreView loadMoreView = new LoadMoreView(parent.getContext());
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        loadMoreView.setLayoutParams(layoutParams);
        return new LoadMoreViewHolder(loadMoreView);
    }
}
