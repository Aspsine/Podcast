package com.aspsine.podcast.data.source.station;

import com.aspsine.podcast.data.entity.StationEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/11/5.
 */

public interface StationDataSource {

    Observable<StationEntity> getStation(String id);

    Observable<List<StationEntity>> getStations();
}
