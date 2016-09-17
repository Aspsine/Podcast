package com.aspsine.podcast.domain;

import java.util.List;

/**
 * Created by aspsine on 16/9/11.
 */

public class Station {
    private String id;
    private String name;
    private String image;
    private List<Podcast> podcasts;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
}
