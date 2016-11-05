package com.aspsine.podcast.data.source.station.local;

import com.aspsine.podcast.data.entity.StationEntity;
import com.aspsine.podcast.data.source.station.StationDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/11/5.
 */

public class LocalStationDataSource implements StationDataSource{


    @Override
    public Observable<StationEntity> getStation(String id) {
        return null;
    }

    @Override
    public Observable<List<StationEntity>> getStations() {
        return null;
    }
}
