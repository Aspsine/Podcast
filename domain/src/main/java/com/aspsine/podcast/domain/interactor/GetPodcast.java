package com.aspsine.podcast.domain.interactor;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.repository.PodcastRepository;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by aspsine on 16/11/5.
 */

public class GetPodcast extends UseCase<Podcast> {

    private final String mPodcastId;
    private final PodcastRepository mPodcastRepository;

    public GetPodcast(String podcastId, PodcastRepository podcastRepository, Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        super(subscribeOnScheduler, observeOnScheduler);
        this.mPodcastId = podcastId;
        this.mPodcastRepository = podcastRepository;
    }

    @Override
    public Observable<Podcast> buildUseCaseObservable() {
        return mPodcastRepository.getPodcast(mPodcastId);
    }
}
