package com.aspsine.podcast.data.source.podcast.remote;

import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.network.RestApi;
import com.aspsine.podcast.data.source.podcast.PodcastDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/9/12.
 */

public class RemotePodcastDataSource implements PodcastDataSource{

    private RestApi mRestApi;

    public RemotePodcastDataSource(RestApi restApi) {
        this.mRestApi = restApi;
    }

    @Override
    public Observable<List<PodcastEntity>> getPodcasts(int page) {
        return mRestApi.getPodcasts(page);
    }

    @Override
    public Observable<List<PodcastEntity>> getPodcasts() {
        return mRestApi.getPodcasts();
    }

    @Override
    public Observable<PodcastEntity> getPodcast(String id) {
        return mRestApi.getPodcast(id);
    }
}
