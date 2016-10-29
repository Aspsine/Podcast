package com.aspsine.podcast.widget.recyclerView.loadmore;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;

/**
 * Created by aspsine on 16/10/22.
 */

public class LoadMoreItemViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<LoadMoreViewModel> {

    private LoadMoreItemView loadMoreView;

    public LoadMoreItemViewHolder(View itemView) {
        super(itemView);
        loadMoreView= (LoadMoreItemView) itemView;
    }

    @Override
    public void onBindViewHolder(int position, LoadMoreViewModel viewModel) {
        loadMoreView.setState(viewModel.getState());
    }
}
