package com.aspsine.podcast.data.source.search;

import com.aspsine.podcast.data.network.RestApi;
import com.aspsine.podcast.data.network.RestApiImpl;
import com.aspsine.podcast.data.source.search.remote.RemoteSearchDataSource;

/**
 * Created by aspsine on 16/10/30.
 */

public class SearchDataSourceFactory {

    public SearchDataSource createRemoteSearchDataSource(){
        RestApi restApi = new RestApiImpl();
        return new RemoteSearchDataSource(restApi);
    }
}
