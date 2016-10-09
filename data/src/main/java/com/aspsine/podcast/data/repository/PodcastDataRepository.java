package com.aspsine.podcast.data.repository;

import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.entity.mapper.PodcastDataMapper;
import com.aspsine.podcast.data.source.PodcastDataSource;
import com.aspsine.podcast.data.source.PodcastDataSourceFactory;
import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.repository.PodcastRepository;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by aspsine on 16/9/12.
 */

public class PodcastDataRepository implements PodcastRepository {

    private final PodcastDataMapper mPodcastDataMapper;

    private final PodcastDataSourceFactory mPodcastDataSourceFactory;

    public PodcastDataRepository(PodcastDataMapper podcastDataMapper, PodcastDataSourceFactory podcastDataSourceFactory) {
        this.mPodcastDataMapper = podcastDataMapper;
        this.mPodcastDataSourceFactory = podcastDataSourceFactory;
    }

    @Override
    public Observable<Podcast> getPodcast(String id) {
        PodcastDataSource podcastDataSource = mPodcastDataSourceFactory.create(id);
        return podcastDataSource.getPodcast(id).map(new Func1<PodcastEntity, Podcast>() {
            @Override
            public Podcast call(PodcastEntity podcastEntity) {
                return mPodcastDataMapper.transform(podcastEntity);
            }
        });
    }

    @Override
    public Observable<List<Podcast>> getPodcasts(int page) {
        PodcastDataSource podcastDataSource = mPodcastDataSourceFactory.createRemotePodcastDataSource();
        return podcastDataSource.getPodcasts(page).map(new Func1<List<PodcastEntity>, List<Podcast>>() {
            @Override
            public List<Podcast> call(List<PodcastEntity> podcastEntities) {
                return mPodcastDataMapper.transform(podcastEntities);
            }
        });
    }

    @Override
    public Observable<List<Podcast>> getPodcasts() {
        PodcastDataSource podcastDataSource = mPodcastDataSourceFactory.createRemotePodcastDataSource();
        return podcastDataSource.getPodcasts().map(new Func1<List<PodcastEntity>, List<Podcast>>() {
            @Override
            public List<Podcast> call(List<PodcastEntity> podcastEntities) {
                return mPodcastDataMapper.transform(podcastEntities);
            }
        });
    }
}
