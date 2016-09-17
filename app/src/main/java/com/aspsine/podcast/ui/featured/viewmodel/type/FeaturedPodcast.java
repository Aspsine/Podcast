package com.aspsine.podcast.ui.featured.viewmodel.type;

import com.aspsine.podcast.domain.Episode;
import com.aspsine.podcast.domain.Podcast;

import java.util.List;

/**
 * Created by aspsine on 16/9/13.
 */
public class FeaturedPodcast {
    private final Podcast podcast;

    public FeaturedPodcast() {
        this.podcast = new Podcast();
    }

    public String getId() {
        return podcast.getId();
    }

    public void setStation(String station) {
        podcast.setStation(station);
    }

    public String getArtwork() {
        return podcast.getArtwork();
    }

    public List<Episode> getEpisodes() {
        return podcast.getEpisodes();
    }

    public void setId(String id) {
        podcast.setId(id);
    }

    public String getName() {
        return podcast.getName();
    }

    public void setArtwork(String artwork) {
        podcast.setArtwork(artwork);
    }

    public String getStation() {
        return podcast.getStation();
    }

    public void setName(String name) {
        podcast.setName(name);
    }

    public void setEpisodes(List<Episode> episodes) {
        podcast.setEpisodes(episodes);
    }
}
