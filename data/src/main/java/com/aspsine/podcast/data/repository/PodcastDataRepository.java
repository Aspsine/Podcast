package com.aspsine.podcast.data.repository;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.repository.PodcastRepository;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/9/12.
 */

public class PodcastDataRepository implements PodcastRepository {

    @Override
    public Observable<Podcast> podcast(String id) {
        return null;
    }

    @Override
    public Observable<List<Podcast>> podcasts() {

        return null;
    }
}
