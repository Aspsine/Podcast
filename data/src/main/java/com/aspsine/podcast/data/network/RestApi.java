package com.aspsine.podcast.data.network;

import com.aspsine.podcast.data.entity.PodcastEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/10/8.
 */

public interface RestApi {

    Observable<List<PodcastEntity>> getPodcasts(int page);

    Observable<List<PodcastEntity>> getPodcasts();

    Observable<PodcastEntity> getPodcast(String id);
}
