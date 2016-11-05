package com.aspsine.podcast.data.source.search.remote;

import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.network.RestApi;
import com.aspsine.podcast.data.source.search.SearchDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/10/30.
 */

public class RemoteSearchDataSource implements SearchDataSource{

    private RestApi mRestApi;

    public RemoteSearchDataSource(RestApi restApi) {
        this.mRestApi = restApi;
    }

    @Override
    public Observable<List<PodcastEntity>> search(String text) {
        return mRestApi.search(text);
    }
}
