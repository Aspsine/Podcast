package com.aspsine.podcast.domain.interactor;

import com.aspsine.podcast.domain.Featured;
import com.aspsine.podcast.domain.repository.FeaturedRepository;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by aspsine on 16/11/5.
 */

public class GetFeaturedList extends UseCase<List<Featured>> {

    private FeaturedRepository mFeaturedRepository;

    public GetFeaturedList(FeaturedRepository featuredRepository, Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        super(subscribeOnScheduler, observeOnScheduler);
        this.mFeaturedRepository = featuredRepository;
    }

    @Override
    public Observable<List<Featured>> buildUseCaseObservable() {
        return mFeaturedRepository.getFeatureds();
    }
}
