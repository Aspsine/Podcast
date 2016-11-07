package com.aspsine.podcast.ui.main.featured.mapper;

import com.aspsine.podcast.domain.Station;
import com.aspsine.podcast.ui.main.featured.item.station.StationListViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/11/6.
 */

public class StationListViewModelDataMapper {

    StationViewModelDataMapper mStationViewModelDataMapper;

    public StationListViewModelDataMapper() {
        mStationViewModelDataMapper = new StationViewModelDataMapper();
    }

    public StationListViewModel transform(List<Station> stations){
        return new StationListViewModel(mStationViewModelDataMapper.transform(stations));
    }
}
