package com.aspsine.podcast.data.entity;

import com.aspsine.podcast.domain.Podcast;

import java.util.List;

/**
 * Created by aspsine on 16/11/5.
 */

public class CategoryEntity {
    private String id;

    private String name;

    private List<PodcastEntity> podcastEntities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PodcastEntity> getPodcastEntities() {
        return podcastEntities;
    }

    public void setPodcastEntities(List<PodcastEntity> podcastEntities) {
        this.podcastEntities = podcastEntities;
    }
}
