package com.aspsine.podcast.data.entity;

import java.util.List;

/**
 * Created by aspsine on 16/10/27.
 */

public class FeaturedEntity {

    public static final int TYPE_FEATURED_TITLE = 1;

    public static final int TYPE_FEATURED_PROVIDER = 11;

    public static final int TYPE_FEATURED_STATION = 12;

    public static final int TYPE_FEATURED_CATEGORY = 13;

    public static final int TYPE_FEATURED_PODCAST = 14;

    public static final int TYPE_FEATURED_EPISODE = 15;

    public static final int TYPE_FEATURED_PROVIDER_LIST = 21;

    public static final int TYPE_FEATURED_STATION_LIST = 22;

    public static final int TYPE_FEATURED_PODCAST_LIST = 23;

    public static final int TYPE_FEATURED_EPISODE_LIST = 24;

    private int type;

    private FeaturedEntity feedEntity;

    private List<FeaturedEntity> feedEntities;

    private TitleEntity titleEntity;

    private EpisodeEntity episodeEntity;

    private PodcastEntity podcastEntity;

    private CategoryEntity categoryEntity;

    private StationEntity stationEntity;

    private ProviderEntity providerEntity;

    private List<EpisodeEntity> episodeEntities;

    private List<PodcastEntity> podcasts;

    private List<StationEntity> stationEntities;

    private List<ProviderEntity> providerEntities;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public FeaturedEntity getFeedEntity() {
        return feedEntity;
    }

    public void setFeedEntity(FeaturedEntity feedEntity) {
        this.feedEntity = feedEntity;
    }

    public List<FeaturedEntity> getFeedEntities() {
        return feedEntities;
    }

    public void setFeedEntities(List<FeaturedEntity> feedEntities) {
        this.feedEntities = feedEntities;
    }

    public TitleEntity getTitleEntity() {
        return titleEntity;
    }

    public void setTitleEntity(TitleEntity titleEntity) {
        this.titleEntity = titleEntity;
    }

    public EpisodeEntity getEpisodeEntity() {
        return episodeEntity;
    }

    public void setEpisodeEntity(EpisodeEntity episodeEntity) {
        this.episodeEntity = episodeEntity;
    }

    public PodcastEntity getPodcastEntity() {
        return podcastEntity;
    }

    public void setPodcastEntity(PodcastEntity podcastEntity) {
        this.podcastEntity = podcastEntity;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public StationEntity getStationEntity() {
        return stationEntity;
    }

    public void setStationEntity(StationEntity stationEntity) {
        this.stationEntity = stationEntity;
    }

    public ProviderEntity getProviderEntity() {
        return providerEntity;
    }

    public void setProviderEntity(ProviderEntity providerEntity) {
        this.providerEntity = providerEntity;
    }

    public List<EpisodeEntity> getEpisodeEntities() {
        return episodeEntities;
    }

    public void setEpisodeEntities(List<EpisodeEntity> episodeEntities) {
        this.episodeEntities = episodeEntities;
    }

    public List<PodcastEntity> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<PodcastEntity> podcasts) {
        this.podcasts = podcasts;
    }

    public List<StationEntity> getStationEntities() {
        return stationEntities;
    }

    public void setStationEntities(List<StationEntity> stationEntities) {
        this.stationEntities = stationEntities;
    }

    public List<ProviderEntity> getProviderEntities() {
        return providerEntities;
    }

    public void setProviderEntities(List<ProviderEntity> providerEntities) {
        this.providerEntities = providerEntities;
    }
}
