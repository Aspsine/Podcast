package com.aspsine.podcast.ui.main.featured.item.station;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderProvider;

/**
 * Created by aspsine on 16/9/18.
 */

public class StationViewHolderProvider implements ItemViewHolderProvider<StationViewHolder> {

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_featured_item_station_list_item_station, parent, false);
        return new StationViewHolder(itemView);
    }
}
