package com.aspsine.podcast.data.repository;

import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.entity.mapper.PodcastDataMapper;
import com.aspsine.podcast.data.source.search.SearchDataSourceFactory;
import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.repository.SearchRepository;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by aspsine on 16/10/30.
 */

public class SearchDataRespository implements SearchRepository{

    private final SearchDataSourceFactory mSearchDataSourceFactory;

    private final PodcastDataMapper mPodcastDataMapper;

    public SearchDataRespository(SearchDataSourceFactory searchDataSourceFactory, PodcastDataMapper podcastDataMapper) {
        this.mSearchDataSourceFactory = searchDataSourceFactory;
        this.mPodcastDataMapper = podcastDataMapper;
    }

    @Override
    public Observable<List<Podcast>> search(String text) {
        return mSearchDataSourceFactory.createRemoteSearchDataSource().search(text).map(new Func1<List<PodcastEntity>, List<Podcast>>() {
            @Override
            public List<Podcast> call(List<PodcastEntity> podcastEntities) {
                return mPodcastDataMapper.transform(podcastEntities);
            }
        });
    }
}
