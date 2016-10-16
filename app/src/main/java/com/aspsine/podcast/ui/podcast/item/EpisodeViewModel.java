package com.aspsine.podcast.ui.podcast.item;

import com.aspsine.podcast.domain.Episode;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

/**
 * Created by aspsine on 16/10/15.
 */

public class EpisodeViewModel implements ItemViewModel {
    private Episode episode;

    public EpisodeViewModel(Episode episode) {
        this.episode = episode;
    }

    public EpisodeViewModel() {
        this.episode = new Episode();
    }

    public String getId() {
        return episode.getId();
    }

    public void setDuration(String duration) {
        episode.setDuration(duration);
    }

    public void setDescription(String description) {
        episode.setDescription(description);
    }

    public void setTitle(String title) {
        episode.setTitle(title);
    }

    public String getDescription() {
        return episode.getDescription();
    }

    public String getPubDate() {
        return episode.getPubDate();
    }

    public void setId(String id) {
        episode.setId(id);
    }

    public void setArtwork(String artwork) {
        episode.setArtwork(artwork);
    }

    public String getDuration() {
        return episode.getDuration();
    }

    public String getArtwork() {
        return episode.getArtwork();
    }

    public void setLink(String link) {
        episode.setLink(link);
    }

    public String getTitle() {
        return episode.getTitle();
    }

    public String getSize() {
        return episode.getSize();
    }

    public void setSize(String size) {
        episode.setSize(size);
    }

    public String getLink() {
        return episode.getLink();
    }

    public void setPubDate(String pubDate) {
        episode.setPubDate(pubDate);
    }
}
