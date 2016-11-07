package com.aspsine.podcast.data.source.episode.remote;

import com.aspsine.podcast.data.entity.EpisodeEntity;
import com.aspsine.podcast.data.source.episode.EpisodeDataSource;

import rx.Observable;

/**
 * Created by aspsine on 16/11/6.
 */

public class RemoteEpisodeDataSource implements EpisodeDataSource{



    @Override
    public Observable<EpisodeEntity> getEpisodes(String podcastId) {

        return null;
    }
}
