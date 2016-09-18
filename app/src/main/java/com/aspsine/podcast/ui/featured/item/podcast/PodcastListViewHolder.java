package com.aspsine.podcast.ui.featured.item.podcast;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.featured.ItemMarginDecoration;
import com.aspsine.podcast.util.DisplayUtil;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

public class PodcastListViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<PodcastListViewModel>{

    public RecyclerView recyclerView;

    public PodcastListViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(itemView.getContext(), 2, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new ItemMarginDecoration(DisplayUtil.dip2px(itemView.getContext(), 12)));
    }

    @Override
    public void onBindViewHolder(int position, PodcastListViewModel podcastListViewModel) {
        ItemViewAdapter adapter = (ItemViewAdapter) recyclerView.getAdapter();
        List<PodcastViewModel> podcastViewModels = podcastListViewModel.getPodcastViewModels();
        if (adapter == null) {
            adapter = new ItemViewAdapter(new ArrayList<ItemViewModel>());
            recyclerView.setAdapter(adapter);
        }
        adapter.setList(podcastViewModels);
    }
}
