package com.aspsine.podcast.ui.main.featured.item.podcast;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.main.featured.ItemMarginDecoration;
import com.aspsine.podcast.util.DisplayUtil;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

class PodcastListViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<PodcastListViewModel> {

    public RecyclerView recyclerView;
    private ItemViewAdapter<PodcastViewModel> mAdapter;

    PodcastListViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        GridLayoutManager layoutManager = new GridLayoutManager(itemView.getContext(), 1, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new ItemMarginDecoration(DisplayUtil.dip2px(itemView.getContext(), 12)));
        mAdapter = new ItemViewAdapter<PodcastViewModel>(new ArrayList<PodcastViewModel>(0));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBindViewHolder(int position, PodcastListViewModel podcastListViewModel) {
        List<PodcastViewModel> podcastViewModels = podcastListViewModel.getPodcastViewModels();
        mAdapter.setList(podcastViewModels);
    }
}
