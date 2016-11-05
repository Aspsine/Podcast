package com.aspsine.podcast.data.source.podcast;

import com.aspsine.podcast.data.entity.PodcastEntity;

import java.util.List;

import rx.Observable;


/**
 * Created by aspsine on 16/9/12.
 */

public interface PodcastDataSource {

    Observable<List<PodcastEntity>> getPodcasts(int page);

    Observable<List<PodcastEntity>> getPodcasts();

    Observable<PodcastEntity> getPodcast(String id);
}
