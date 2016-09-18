package com.aspsine.podcast.ui.featured.item.station;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.podcast.ui.featured.ItemMarginDecoration;
import com.aspsine.podcast.util.DisplayUtil;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;

/**
 * Created by aspsine on 16/9/18.
 */

public class StationListViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<StationListViewModel>{
    private RecyclerView recyclerView;

    public StationListViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView;
        recyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(), 1, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new ItemMarginDecoration(DisplayUtil.dip2px(itemView.getContext(), 12)));
    }

    @Override
    public void onBindViewHolder(int position, StationListViewModel stationListViewModel) {
        ItemViewAdapter adapter = (ItemViewAdapter) recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new ItemViewAdapter(new ArrayList<ItemViewModel>(0));
            recyclerView.setAdapter(adapter);
        }
        adapter.setList(stationListViewModel.getStationViewModels());
    }

}
