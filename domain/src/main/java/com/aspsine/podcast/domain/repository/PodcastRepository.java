package com.aspsine.podcast.domain.repository;

import com.aspsine.podcast.domain.Podcast;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/9/12.
 */

public interface PodcastRepository {

    Observable<Podcast> podcast(String id);

    Observable<List<Podcast>> podcasts();
}
