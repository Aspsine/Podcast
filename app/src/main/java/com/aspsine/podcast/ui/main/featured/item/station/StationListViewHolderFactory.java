package com.aspsine.podcast.ui.main.featured.item.station;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderFactory;

/**
 * Created by aspsine on 16/9/18.
 */

public class StationListViewHolderFactory implements ItemViewHolderFactory<StationListViewHolder> {
    @Override
    public StationListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_featured_item_station_list, parent, false);
        return new StationListViewHolder(itemView);
    }
}
