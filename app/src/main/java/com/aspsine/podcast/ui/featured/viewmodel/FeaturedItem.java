package com.aspsine.podcast.ui.featured.viewmodel;

import android.support.annotation.IntDef;

import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedBanner;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedEpisode;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedEpisodeList;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedHotTagList;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedPodcast;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedPodcastList;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedProvider;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedProviderList;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedStation;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedStationList;

/**
 * Created by aspsine on 16/9/13.
 */

public class FeaturedItem {

    public static final int TYPE_FEATURED_TITLE = 1;

    public static final int TYPE_FEATURED_PROVIDER = 11;

    public static final int TYPE_FEATURED_STATION = 12;

    public static final int TYPE_FEATURED_PODCAST = 13;

    public static final int TYPE_FEATURED_EPISODE = 14;

    public static final int TYPE_FEATURED_PROVIDER_LIST = 21;

    public static final int TYPE_FEATURED_STATION_LIST = 22;

    public static final int TYPE_FEATURED_PODCAST_LIST = 23;

    public static final int TYPE_FEATURED_EPISODE_LIST = 24;

    public static final int TYPE_FEATURED_BANNER = 31;

    public static final int TYPE_FEATURED_HOT_TAG_LIST = 41;

    @IntDef(value = {
            TYPE_FEATURED_TITLE,
            TYPE_FEATURED_PROVIDER,
            TYPE_FEATURED_STATION,
            TYPE_FEATURED_PODCAST,
            TYPE_FEATURED_EPISODE,
            TYPE_FEATURED_PROVIDER_LIST,
            TYPE_FEATURED_STATION_LIST,
            TYPE_FEATURED_PODCAST_LIST,
            TYPE_FEATURED_EPISODE_LIST,
            TYPE_FEATURED_HOT_TAG_LIST,
            TYPE_FEATURED_BANNER,
    })
    @interface Type {
    }

    @Type
    private int type;

    private FeaturedTitle featuredTitle;

    private FeaturedHotTagList featuredHotTagList;

    private FeaturedProvider featuredProvider;

    private FeaturedStation featuredStation;

    private FeaturedPodcast featuredPodcast;

    private FeaturedEpisode featuredEpisode;

    private FeaturedProviderList featuredProviderList;

    private FeaturedStationList featuredStationList;

    private FeaturedPodcastList featuredPodcastList;

    private FeaturedEpisodeList featuredEpisodeList;

    private FeaturedBanner featuredBanner;

    public FeaturedItem() {
    }

    public FeaturedItem(@Type int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(@Type int type) {
        this.type = type;
    }

    public FeaturedTitle getFeaturedTitle() {
        return featuredTitle;
    }

    public void setFeaturedTitle(FeaturedTitle featuredTitle) {
        this.featuredTitle = featuredTitle;
    }

    public FeaturedHotTagList getFeaturedHotTagList() {
        return featuredHotTagList;
    }

    public void setFeaturedHotTagList(FeaturedHotTagList featuredHotTagList) {
        this.featuredHotTagList = featuredHotTagList;
    }

    public FeaturedProvider getFeaturedProvider() {
        return featuredProvider;
    }

    public void setFeaturedProvider(FeaturedProvider featuredProvider) {
        this.featuredProvider = featuredProvider;
    }

    public FeaturedStation getFeaturedStation() {
        return featuredStation;
    }

    public void setFeaturedStation(FeaturedStation featuredStation) {
        this.featuredStation = featuredStation;
    }

    public FeaturedPodcast getFeaturedPodcast() {
        return featuredPodcast;
    }

    public void setFeaturedPodcast(FeaturedPodcast featuredPodcast) {
        this.featuredPodcast = featuredPodcast;
    }

    public FeaturedEpisode getFeaturedEpisode() {
        return featuredEpisode;
    }

    public void setFeaturedEpisode(FeaturedEpisode featuredEpisode) {
        this.featuredEpisode = featuredEpisode;
    }

    public FeaturedProviderList getFeaturedProviderList() {
        return featuredProviderList;
    }

    public void setFeaturedProviderList(FeaturedProviderList featuredProviderList) {
        this.featuredProviderList = featuredProviderList;
    }

    public FeaturedStationList getFeaturedStationList() {
        return featuredStationList;
    }

    public void setFeaturedStationList(FeaturedStationList featuredStationList) {
        this.featuredStationList = featuredStationList;
    }

    public FeaturedPodcastList getFeaturedPodcastList() {
        return featuredPodcastList;
    }

    public void setFeaturedPodcastList(FeaturedPodcastList featuredPodcastList) {
        this.featuredPodcastList = featuredPodcastList;
    }

    public FeaturedEpisodeList getFeaturedEpisodeList() {
        return featuredEpisodeList;
    }

    public void setFeaturedEpisodeList(FeaturedEpisodeList featuredEpisodeList) {
        this.featuredEpisodeList = featuredEpisodeList;
    }

    public FeaturedBanner getFeaturedBanner() {
        return featuredBanner;
    }

    public void setFeaturedBanner(FeaturedBanner featuredBanner) {
        this.featuredBanner = featuredBanner;
    }
}
