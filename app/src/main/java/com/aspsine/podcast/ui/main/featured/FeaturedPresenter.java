package com.aspsine.podcast.ui.main.featured;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.aspsine.podcast.ui.main.featured.item.banner.BannerViewModel;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastListViewModel;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastViewModel;
import com.aspsine.podcast.ui.main.featured.item.station.StationListViewModel;
import com.aspsine.podcast.ui.main.featured.item.station.StationViewModel;
import com.aspsine.podcast.ui.main.featured.item.tag.TagListViewModel;
import com.aspsine.podcast.ui.main.featured.item.tag.TagViewModel;
import com.aspsine.podcast.ui.main.featured.item.title.TitleViewModel;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/11.
 */

public class FeaturedPresenter implements FeaturedContract.Presenter {

    private FeaturedContract.View mView;

    private int mPage;

    public FeaturedPresenter(@NonNull FeaturedContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        mView.startRefresh();
        refresh();
    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.bindRefreshData(getMockedRefreshItems());
                mView.stopRefresh();
            }
        }, 500);
    }

    @Override
    public void loadMore() {
        mView.startLoadMore();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.bindLoadMoreData(getMockedLoadMoreItems());
            }
        }, 1000);
    }

    private BannerViewModel getMockedBanner() {
        BannerViewModel bannerViewModel = new BannerViewModel();
        List<ItemViewModel> itemViewModels = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            PodcastViewModel podcastViewModel = new PodcastViewModel();
            podcastViewModel.setArtwork("http://ichef.bbci.co.uk/images/ic/480xn/p047q6by.jpg");
            itemViewModels.add(podcastViewModel);
        }
        bannerViewModel.setItemViewModels(itemViewModels);

        return bannerViewModel;
    }

    private List<ItemViewModel> getMockedRefreshItems() {
        List<ItemViewModel> itemViewModels = new ArrayList<>();

        itemViewModels.add(getMockedBanner());

        for (int i = 0; i < 100; i++) {
            int type = i % 10;
            if (type == 1) {
                TitleViewModel titleViewModel = new TitleViewModel();
                titleViewModel.setText("Title:" + i);
                itemViewModels.add(titleViewModel);
            } else if (type == 3) {

                PodcastListViewModel podcastListViewModel = new PodcastListViewModel();
                List<PodcastViewModel> podcastViewModels = new ArrayList<>();
                for (int j = 0; j < 30; j++) {
                    PodcastViewModel podcastViewModel = new PodcastViewModel();
                    podcastViewModel.setId(String.valueOf(i + "" + j));
                    podcastViewModel.setName("Podcast:" + i + j);
                    podcastViewModel.setStation("Station:" + i + j);
                    podcastViewModel.setArtwork("http://ichef.bbci.co.uk/images/ic/224x224/p03qg0sb.jpg");
                    podcastViewModels.add(podcastViewModel);
                }
                podcastListViewModel.setPodcastViewModels(podcastViewModels);
                itemViewModels.add(podcastListViewModel);

            } else if (type == 4) {
                TagListViewModel tagListViewModel = new TagListViewModel();
                List<TagViewModel> tagViewModels = new ArrayList<>();
                for (int j = 0; j < 20; j++) {
                    TagViewModel tagViewModel = new TagViewModel();
                    tagViewModel.setId(i + "" + j);
                    tagViewModel.setText("TAG " + i + j);
                    tagViewModels.add(tagViewModel);
                }
                tagListViewModel.setTagViewModels(tagViewModels);
                itemViewModels.add(tagListViewModel);

            } else if (type == 5) {
                StationListViewModel stationListViewModel = new StationListViewModel();
                List<StationViewModel> stationViewModels = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    StationViewModel stationViewModel = new StationViewModel();
                    stationViewModel.setId(i + "" + j);
                    stationViewModel.setName("Station:" + i + j);
                    stationViewModel.setImage("http://ichef.bbci.co.uk/images/ic/480xn/p04712p3.jpg");
                    stationViewModels.add(stationViewModel);
                }
                stationListViewModel.setStationViewModels(stationViewModels);
                itemViewModels.add(stationListViewModel);
            }
        }

        return itemViewModels;
    }

    private List<ItemViewModel> getMockedLoadMoreItems() {
        return null;
    }
}
