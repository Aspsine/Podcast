package com.aspsine.podcast.ui.main.discover;

import com.aspsine.podcast.data.entity.mapper.PodcastDataMapper;
import com.aspsine.podcast.data.repository.PodcastDataRepository;
import com.aspsine.podcast.data.source.podcast.PodcastDataSourceFactory;
import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.interactor.GetPodcastList;
import com.aspsine.podcast.domain.repository.PodcastRepository;
import com.aspsine.podcast.ui.main.discover.mapper.DiscoverPodcastViewModelMapper;
import com.aspsine.podcast.util.L;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangfan10 on 16/10/8.
 */

public class DiscoverPresenter implements DiscoverContract.Presenter {

    private final DiscoverContract.View mView;

    private final DiscoverPodcastViewModelMapper mDiscoverPodcastViewModelMapper;

    private final GetPodcastList mGetPodcasts;

    private int mPage;

    public DiscoverPresenter(DiscoverContract.View view) {
        this.mView = view;
        this.mDiscoverPodcastViewModelMapper = new DiscoverPodcastViewModelMapper();
        PodcastRepository podcastRepository = new PodcastDataRepository(new PodcastDataMapper(), new PodcastDataSourceFactory());
        this.mGetPodcasts = new GetPodcastList(podcastRepository, Schedulers.io(), AndroidSchedulers.mainThread());
    }

    @Override
    public void start() {
        mView.startRefresh();
        refresh();
    }

    @Override
    public void destroy() {
        mGetPodcasts.unSubscribe();
    }

    @Override
    public void refresh() {
        mPage = 1;

        loadRxRefreshData(new Subscriber<List<Podcast>>() {
            @Override
            public void onNext(List<Podcast> podcasts) {
                List<ItemViewModel> itemViewModels = new ArrayList<ItemViewModel>();
                if (podcasts != null && !podcasts.isEmpty()) {
                    mPage++;
                    itemViewModels.addAll(mDiscoverPodcastViewModelMapper.transform(podcasts));
                    mView.bindRefreshData(itemViewModels);
                } else {
                    mView.bindRefreshData(itemViewModels);
                }
            }

            @Override
            public void onCompleted() {
                mView.stopRefresh();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mView.refreshError();
            }
        });
    }

    @Override
    public void loadMore() {
        L.i("More load :" + mPage);
        loadRxRefreshData(new Subscriber<List<Podcast>>() {
            @Override
            public void onNext(List<Podcast> podcasts) {
                if (podcasts != null && !podcasts.isEmpty()) {
                    mPage++;
                    List<ItemViewModel> itemViewModels = new ArrayList<ItemViewModel>();
                    itemViewModels.addAll(mDiscoverPodcastViewModelMapper.transform(podcasts));
                    mView.bindLoadMoreData(itemViewModels);
                }
            }

            @Override
            public void onCompleted() {
                mView.stopLoadMore();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mView.loadMoreError();
            }
        });
    }

    private void loadRxRefreshData(Subscriber<List<Podcast>> subscriber) {
        mGetPodcasts.setPageIndex(mPage).execute(subscriber);
    }
}
