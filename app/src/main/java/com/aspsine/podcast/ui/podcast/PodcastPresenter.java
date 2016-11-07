package com.aspsine.podcast.ui.podcast;

import android.util.Log;

import com.aspsine.podcast.data.entity.EpisodeEntity;
import com.aspsine.podcast.data.entity.mapper.PodcastDataMapper;
import com.aspsine.podcast.data.network.RestApi;
import com.aspsine.podcast.data.network.RestApiImpl;
import com.aspsine.podcast.data.repository.PodcastDataRepository;
import com.aspsine.podcast.data.source.podcast.PodcastDataSourceFactory;
import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.interactor.GetPodcast;

import java.util.List;

import rx.SimpleObserver;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by aspsine on 16/10/15.
 */

public class PodcastPresenter implements PodcastContract.Presenter {

    private PodcastContract.View mView;

    private final GetPodcast mGetPodcast;

    private String id;


    public PodcastPresenter(PodcastContract.View view, String podcastId) {
        this.mView = view;
        mGetPodcast = new GetPodcast(podcastId, new PodcastDataRepository(new PodcastDataMapper(), new PodcastDataSourceFactory()), Schedulers.io(), AndroidSchedulers.mainThread());
    this.id = podcastId;
    }

    @Override
    public void start() {
        mView.startRefresh();
        refresh();
    }

    @Override
    public void refresh() {
        mGetPodcast.execute(new Subscriber<Podcast>() {

            @Override
            public void onNext(Podcast podcast) {
                mView.bindRefreshData(new PodcastViewModel(podcast));
            }

            @Override
            public void onCompleted() {
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
