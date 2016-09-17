package com.aspsine.podcast.ui.featured;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.aspsine.podcast.domain.Station;
import com.aspsine.podcast.ui.featured.viewmodel.Featured;
import com.aspsine.podcast.ui.featured.viewmodel.FeaturedItem;
import com.aspsine.podcast.ui.featured.viewmodel.FeaturedTitle;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedBanner;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedPodcast;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedPodcastList;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedStation;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedStationList;

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
                mView.bindRefreshData(getMockRefreshItems());
                mView.stopRefresh();
            }
        }, 2000);
    }

    @Override
    public void loadMore() {
        mView.startLoadMore();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.bindLoadMoreData(getMockRefreshItems());
            }
        }, 1000);
    }

    private FeaturedItem getMockBanner() {

        FeaturedItem featuredItem = new FeaturedItem(FeaturedItem.TYPE_FEATURED_BANNER);

        FeaturedBanner featuredBanner = new FeaturedBanner();

        List<FeaturedItem> featuredItems = new ArrayList<>();

//        FeaturedItem featuredItem0 = new FeaturedItem(FeaturedItem.TYPE_FEATURED_PROVIDER);
//        FeaturedProvider featuredProvider = new FeaturedProvider();
//        featuredProvider.setId("0");
//        featuredProvider.setImage("https://ichef.bbci.co.uk/images/ic/256x144/p01lcfdr.jpg");
//        featuredItem0.setFeaturedProvider(featuredProvider);
//        featuredItems.add(featuredItem0);
//
//        FeaturedItem featuredItem1 = new FeaturedItem(FeaturedItem.TYPE_FEATURED_STATION);
//        FeaturedStation featuredStation = new FeaturedStation();
//        featuredStation.setId("1");
//        featuredStation.setImage("http://ichef.bbci.co.uk/images/ic/304x171/p0479v7y.jpg");
//        featuredItem1.setFeaturedStation(featuredStation);
//        featuredItems.add(featuredItem1);

        for (int i = 0; i < 5; i++) {
            FeaturedItem featuredItem2 = new FeaturedItem(FeaturedItem.TYPE_FEATURED_PODCAST);
            FeaturedPodcast featuredPodcast = new FeaturedPodcast();
            featuredPodcast.setId("2");
            featuredPodcast.setArtwork("https://ichef.bbci.co.uk/images/ic/304x171/p0322s4l.jpg");
            featuredItem2.setFeaturedPodcast(featuredPodcast);
            featuredItems.add(featuredItem2);
        }

        featuredBanner.setFeaturedItems(featuredItems);

        featuredItem.setFeaturedBanner(featuredBanner);

//        FeaturedItem featuredItem3 = new FeaturedItem(FeaturedItem.TYPE_FEATURED_EPISODE);
//        FeaturedEpisode featuredEpisode = new FeaturedEpisode();
//        featuredEpisode.setId("3");
//        featuredEpisode.setArtwork("https://ichef.bbci.co.uk/images/ic/304x171/p01t7xy8.jpg");
//        featuredItem3.setFeaturedEpisode(featuredEpisode);
//        featuredItems.add(featuredItem3);

        return featuredItem;
    }

    private List<FeaturedItem> getMockRefreshItems() {

        List<FeaturedItem> featuredItems = new ArrayList<>();

        featuredItems.add(getMockBanner());

        for (int i = 0; i < 100; i++) {
            if (i % 10 == 1) {
                FeaturedItem featuredTitleItem = new FeaturedItem(FeaturedItem.TYPE_FEATURED_TITLE);
                FeaturedTitle featuredTitle = new FeaturedTitle();
                featuredTitle.setText("Title " + i);
                featuredTitleItem.setFeaturedTitle(featuredTitle);
                featuredItems.add(featuredTitleItem);
            }else  if (i % 10 == 2){
                FeaturedItem featuredItem = new FeaturedItem(FeaturedItem.TYPE_FEATURED_STATION_LIST);
                FeaturedStationList featuredStationList = new FeaturedStationList();
                List<FeaturedStation> featuredStations = new ArrayList<>();
                for (int j = 0; j< 20; j++){
                    FeaturedStation featuredStation = new FeaturedStation();
                    featuredStation.setId(i + "" + j);
                    featuredStation.setImage("http://ichef.bbci.co.uk/images/ic/304x171/p035djqv.jpg");
                    featuredStations.add(featuredStation);
                }
                featuredStationList.setFeaturedStations(featuredStations);
                featuredItem.setFeaturedStationList(featuredStationList);
                featuredItems.add(featuredItem);

            }else if (i% 10 == 3) {
                FeaturedItem featuredItem = new FeaturedItem(FeaturedItem.TYPE_FEATURED_PODCAST_LIST);
                FeaturedPodcastList featuredPodcastList = new FeaturedPodcastList();
                List<FeaturedPodcast> featuredPodcasts = new ArrayList<>();
                for (int j = 0; j < 30; j++) {
                    FeaturedPodcast featuredPodcast = new FeaturedPodcast();
                    featuredPodcast.setId(String.valueOf(j));
                    featuredPodcast.setArtwork("http://ichef.bbci.co.uk/images/ic/304x171/p02rt7vj.jpg");
                    featuredPodcast.setName("Podcast" + i);
                    featuredPodcast.setStation("Station " + j);
                    featuredPodcasts.add(featuredPodcast);
                }
                featuredPodcastList.setFeaturedPodcasts(featuredPodcasts);
                featuredItem.setFeaturedPodcastList(featuredPodcastList);
                featuredItems.add(featuredItem);
            }
        }

        return featuredItems;
    }

    private List<FeaturedItem> getMockLoadMoreItems(int page) {
        return null;
    }

    private List<FeaturedItem> getMockItems() {
        return null;
    }


}
