package com.aspsine.podcast.ui.featured.item.station;

import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedStation;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

public class StationListViewModel implements ItemViewModel{
    private List<FeaturedStation> featuredStations;

    public List<FeaturedStation> getFeaturedStations() {
        return featuredStations;
    }

    public void setFeaturedStations(List<FeaturedStation> featuredStations) {
        this.featuredStations = featuredStations;
    }
}
