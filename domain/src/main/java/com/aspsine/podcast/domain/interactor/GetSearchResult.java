package com.aspsine.podcast.domain.interactor;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.repository.SearchRepository;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by aspsine on 16/11/5.
 */

public class GetSearchResult extends UseCase<List<Podcast>>{

    private String mKeyword;

    private SearchRepository mSearchRepository;

    public GetSearchResult(SearchRepository searchRepository, Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        super(subscribeOnScheduler, observeOnScheduler);
        this.mSearchRepository = searchRepository;
    }

    public GetSearchResult setKeyword(String keyword){
        this.mKeyword = keyword;
        return this;
    }

    @Override
    public Observable<List<Podcast>> buildUseCaseObservable() {
        return mSearchRepository.search(mKeyword);
    }
}
