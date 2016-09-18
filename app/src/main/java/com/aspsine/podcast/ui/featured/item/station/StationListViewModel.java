package com.aspsine.podcast.ui.featured.item.station;

import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedStation;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

public class StationListViewModel implements ItemViewModel{
    private List<StationViewModel> stationViewModels;

    public List<StationViewModel> getStationViewModels() {
        return stationViewModels;
    }

    public void setStationViewModels(List<StationViewModel> stationViewModels) {
        this.stationViewModels = stationViewModels;
    }
}