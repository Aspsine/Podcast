package com.aspsine.podcast.ui.featured.viewmodel.type;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by zhangfan10 on 16/9/13.
 */
public class FeaturedStationList implements ItemViewModel{
    private List<FeaturedStation> featuredStations;

    public List<FeaturedStation> getFeaturedStations() {
        return featuredStations;
    }

    public void setFeaturedStations(List<FeaturedStation> featuredStations) {
        this.featuredStations = featuredStations;
    }
}
