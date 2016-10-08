package com.aspsine.podcast.data.source.remote;

import com.aspsine.podcast.data.model.Podcast;
import com.aspsine.podcast.data.source.PodcastDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/9/12.
 */

public class RemotePodcastDataSource implements PodcastDataSource{

    @Override
    public Observable<List<Podcast>> podcasts() {

        return null;
    }

    @Override
    public Observable<Podcast> podcast(String id) {
        return null;
    }
}
