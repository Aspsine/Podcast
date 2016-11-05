package com.aspsine.podcast.data.source.station.remote;

import com.aspsine.podcast.data.entity.StationEntity;
import com.aspsine.podcast.data.network.RestApi;
import com.aspsine.podcast.data.source.station.StationDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/11/5.
 */

public class RemoteStationDataSource implements StationDataSource {

    private RestApi mRestApi;

    public RemoteStationDataSource(RestApi restApi) {
        this.mRestApi = restApi;
    }

    @Override
    public Observable<StationEntity> getStation(String id) {
        return mRestApi.getStation(id);
    }

    @Override
    public Observable<List<StationEntity>> getStations() {
        return mRestApi.getStations();
    }
}
