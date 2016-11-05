package com.aspsine.podcast.data.source.search;

import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.network.RestApi;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/10/30.
 */

public interface SearchDataSource {

    Observable<List<PodcastEntity>> search(String text);
}
