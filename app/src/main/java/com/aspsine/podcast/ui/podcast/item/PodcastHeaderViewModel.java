package com.aspsine.podcast.ui.podcast.item;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

/**
 * Created by aspsine on 16/10/23.
 */

public class PodcastHeaderViewModel implements ItemViewModel{
    private Podcast podcast;

    public PodcastHeaderViewModel(Podcast podcast) {
        this.podcast = podcast;
    }

    public String getId() {
        return podcast.getId();
    }

    public void setId(String id) {
        podcast.setId(id);
    }

    public String getName() {
        return podcast.getName();
    }

    public void setName(String name) {
        podcast.setName(name);
    }

    public String getArtwork() {
        return podcast.getArtwork();
    }

    public void setArtwork(String artwork) {
        podcast.setArtwork(artwork);
    }

    public String getStation() {
        return podcast.getStation();
    }

    public void setStation(String station) {
        podcast.setStation(station);
    }

    public String getLastUpdate() {
        return podcast.getLastUpdate();
    }

    public void setLastUpdate(String lastUpdate) {
        podcast.setLastUpdate(lastUpdate);
    }

    public String getDescription() {
        return podcast.getDescription();
    }

    public void setDescription(String description) {
        podcast.setDescription(description);
    }
}
