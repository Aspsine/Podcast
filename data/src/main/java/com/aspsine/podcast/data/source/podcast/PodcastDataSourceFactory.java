package com.aspsine.podcast.data.source.podcast;

import com.aspsine.podcast.data.network.RestApi;
import com.aspsine.podcast.data.network.RestApiImpl;
import com.aspsine.podcast.data.source.podcast.remote.RemotePodcastDataSource;

/**
 * Created by aspsine on 16/9/12.
 */

public class PodcastDataSourceFactory {

    public PodcastDataSource create(String id) {

        return createRemotePodcastDataSource();
    }

    public PodcastDataSource createRemotePodcastDataSource() {
        RestApi restApi = new RestApiImpl();
        return new RemotePodcastDataSource(restApi);
    }
}
