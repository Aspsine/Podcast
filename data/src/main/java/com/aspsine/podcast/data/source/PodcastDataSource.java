package com.aspsine.podcast.data.source;

import com.aspsine.podcast.data.model.Podcast;

import java.util.List;

import rx.Observable;


/**
 * Created by aspsine on 16/9/12.
 */

public interface PodcastDataSource {

    Observable<List<Podcast>> podcasts();

    Observable<Podcast> podcast(String id);
}
