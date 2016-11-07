package com.aspsine.podcast.data.source.episode;

import com.aspsine.podcast.data.entity.EpisodeEntity;

import rx.Observable;

/**
 * Created by aspsine on 16/11/6.
 */

public interface EpisodeDataSource {

    Observable<EpisodeEntity> getEpisodes(String podcastId);
}
