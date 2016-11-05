package com.aspsine.podcast.domain.interactor;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.repository.PodcastRepository;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by aspsine on 16/11/5.
 */

public class GetPodcastList extends UseCase<List<Podcast>> {

    private int mPageIndex;

    private final PodcastRepository mPodcastRepository;

    public GetPodcastList(PodcastRepository podcastRepository, Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        super(subscribeOnScheduler, observeOnScheduler);
        this.mPodcastRepository = podcastRepository;
    }

    public GetPodcastList setPageIndex(int pageIndex) {
        this.mPageIndex = pageIndex;
        return this;
    }

    @Override
    public Observable<List<Podcast>> buildUseCaseObservable() {
        return mPodcastRepository.getPodcasts(mPageIndex);
    }
}
