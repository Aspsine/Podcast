package com.aspsine.podcast.data.source.search.local;

import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.source.search.SearchDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/10/30.
 */

public class LocalSearchDataSource implements SearchDataSource{
    @Override
    public Observable<List<PodcastEntity>> search(String text) {
        return null;
    }
}
