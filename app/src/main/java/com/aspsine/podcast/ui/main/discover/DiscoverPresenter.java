package com.aspsine.podcast.ui.main.discover;

import com.aspsine.podcast.data.entity.mapper.PodcastDataMapper;
import com.aspsine.podcast.data.repository.PodcastDataRepository;
import com.aspsine.podcast.data.source.PodcastDataSourceFactory;
import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.repository.PodcastRepository;
import com.aspsine.podcast.ui.main.discover.item.DiscoverPodcastViewModel;
import com.aspsine.podcast.ui.main.discover.mapper.DiscoverPodcastViewModelMapper;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by zhangfan10 on 16/10/8.
 */

public class DiscoverPresenter implements DiscoverContract.Presenter {

    private final DiscoverContract.View mView;

    private final DiscoverPodcastViewModelMapper mDiscoverPodcastViewModelMapper;

    private int mPage;

    public DiscoverPresenter(DiscoverContract.View view) {
        this.mView = view;
        mDiscoverPodcastViewModelMapper = new DiscoverPodcastViewModelMapper();
    }

    @Override
    public void start() {
        mView.startRefresh();
        refresh();
    }

    @Override
    public void refresh() {
        mPage = 1;
        loadRxRefreshData();
    }

    @Override
    public void loadMore() {
        loadRxRefreshData();
    }

    private void loadRxRefreshData(){
        PodcastDataMapper podcastDataMapper = new PodcastDataMapper();
        PodcastDataSourceFactory podcastDataSourceFactory = new PodcastDataSourceFactory();
        PodcastRepository podcastRepository = new PodcastDataRepository(podcastDataMapper, podcastDataSourceFactory);
        podcastRepository.getPodcasts(mPage).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Podcast>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mView.stopRefresh();
            }

            @Override
            public void onNext(List<Podcast> podcasts) {
                List<ItemViewModel> itemViewModels = new ArrayList<ItemViewModel>();
                itemViewModels.addAll(mDiscoverPodcastViewModelMapper.transform(podcasts));
                if (mPage == 1) {
                    mPage++;
                    mView.stopRefresh();
                    mView.bindRefreshData(itemViewModels);
                } else {
                    mPage++;
                    mView.stopLoadMore();
                    mView.bindLoadMoreData(itemViewModels);
                }
            }
        });
    }

}
