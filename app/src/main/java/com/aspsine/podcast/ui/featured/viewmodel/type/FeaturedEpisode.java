package com.aspsine.podcast.ui.featured.viewmodel.type;

import com.aspsine.podcast.domain.Episode;

/**
 * Created by zhangfan10 on 16/9/13.
 */

public class FeaturedEpisode {

    private final Episode episode;

    public FeaturedEpisode() {
        this.episode = new Episode();
    }

    public String getId() {
        return episode.getId();
    }

    public String getTitle() {
        return episode.getTitle();
    }

    public String getPubDate() {
        return episode.getPubDate();
    }

    public String getArtwork() {
        return episode.getArtwork();
    }

    public String getDuration() {
        return episode.getDuration();
    }

    public String getLink() {
        return episode.getLink();
    }

    public void setDescription(String description) {
        episode.setDescription(description);
    }

    public void setLink(String link) {
        episode.setLink(link);
    }

    public void setId(String id) {
        episode.setId(id);
    }

    public void setPubDate(String pubDate) {
        episode.setPubDate(pubDate);
    }

    public String getSize() {
        return episode.getSize();
    }

    public void setArtwork(String artwork) {
        episode.setArtwork(artwork);
    }

    public void setSize(String size) {
        episode.setSize(size);
    }

    public void setTitle(String title) {
        episode.setTitle(title);
    }

    public void setDuration(String duration) {
        episode.setDuration(duration);
    }

    public String getDescription() {
        return episode.getDescription();
    }
}
