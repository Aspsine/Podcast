package com.aspsine.podcast.domain.repository;

import com.aspsine.podcast.domain.Episode;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/9/12.
 */

public interface EpisodeRepository {

    Observable<Episode> episode(String id);

    Observable<List<Episode>> episodes();

}
