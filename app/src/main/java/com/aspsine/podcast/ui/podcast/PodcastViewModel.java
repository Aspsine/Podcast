package com.aspsine.podcast.ui.podcast;

import com.aspsine.podcast.domain.Episode;
import com.aspsine.podcast.domain.Podcast;

import java.util.List;

/**
 * Created by aspsine on 16/10/15.
 */

public class PodcastViewModel {

    private Podcast podcast;

    public PodcastViewModel() {
        this.podcast = new Podcast();
    }

    public PodcastViewModel(Podcast podcast) {
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

    public List<Episode> getEpisodes() {
        return podcast.getEpisodes();
    }

    public void setEpisodes(List<Episode> episodes) {
        podcast.setEpisodes(episodes);
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
