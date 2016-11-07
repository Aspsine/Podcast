package com.aspsine.podcast.data.entity;

import java.util.List;

/**
 * Created by aspsine on 16/11/5.
 */

public class CategoryEntity {
    private String id;

    private String href;

    private String name;

    private List<PodcastEntity> podcastEntities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
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
