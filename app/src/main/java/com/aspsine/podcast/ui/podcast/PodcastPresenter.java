package com.aspsine.podcast.ui.podcast;

import com.aspsine.podcast.data.entity.mapper.PodcastDataMapper;
import com.aspsine.podcast.data.repository.PodcastDataRepository;
import com.aspsine.podcast.data.source.PodcastDataSourceFactory;
import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.repository.PodcastRepository;

import rx.SimpleObserver;

/**
 * Created by aspsine on 16/10/15.
 */

public class PodcastPresenter implements PodcastContract.Presenter {

    private PodcastContract.View mView;

    private final PodcastRepository mPodcastRepository;

    private final String mPodcastId;

    public PodcastPresenter(PodcastContract.View view, String podcastId) {
        this.mView = view;
        this.mPodcastId = podcastId;
        this.mPodcastRepository = new PodcastDataRepository(new PodcastDataMapper(), new PodcastDataSourceFactory());
    }

    @Override
    public void start() {
        mView.startRefresh();
        refresh();
    }

    @Override
    public void refresh() {
        mPodcastRepository.getPodcast(mPodcastId).subscribe(new SimpleObserver<Podcast>() {

            @Override
            public void onNext(Podcast podcast) {
                mView.bindRefreshData(new PodcastViewModel(podcast));
                mView.stopRefresh();
            }

            @Override
            public void onError(Throwable e) {
                mView.refreshError();
                e.printStackTrace();
            }
        });
    }

}
