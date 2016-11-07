package com.aspsine.podcast.data.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by littlexi on 2015/4/12.
 */
public class StationEntity implements Serializable{
    private String id;
    private String name;
    private String href;
    private String image;
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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<PodcastEntity> getPodcastEntities() {
        return podcastEntities;
    }

    public void setPodcastEntities(List<PodcastEntity> podcastEntities) {
        this.podcastEntities = podcastEntities;
    }
}
