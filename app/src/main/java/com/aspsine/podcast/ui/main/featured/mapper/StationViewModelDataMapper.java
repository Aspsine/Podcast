package com.aspsine.podcast.ui.main.featured.mapper;

import com.aspsine.podcast.domain.Station;
import com.aspsine.podcast.ui.main.featured.item.station.StationViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/11/6.
 */

public class StationViewModelDataMapper {
    public StationViewModel transform(Station station) {
        station.setImage("http://ichef.bbci.co.uk/images/ic/480xn/p04712p3.jpg");
        return new StationViewModel(station);
    }

    public List<StationViewModel> transform(List<Station> stations) {
        List<StationViewModel> stationViewModels = new ArrayList<>();
        for (Station station : stations) {
            stationViewModels.add(transform(station));
        }
        return stationViewModels;
    }
}
