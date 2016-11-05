package com.aspsine.podcast.data.source.station;

import com.aspsine.podcast.data.network.RestApi;
import com.aspsine.podcast.data.network.RestApiImpl;
import com.aspsine.podcast.data.source.station.remote.RemoteStationDataSource;

/**
 * Created by aspsine on 16/11/5.
 */
public class StationDataSourceFactory {


    public RemoteStationDataSource createRemoteStationDataSource(){
        RestApi restApi = new RestApiImpl();
        return new RemoteStationDataSource(restApi);
    }
}
