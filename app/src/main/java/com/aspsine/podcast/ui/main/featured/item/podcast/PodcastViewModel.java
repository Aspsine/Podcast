package com.aspsine.podcast.ui.main.featured.item.podcast;

import com.aspsine.podcast.domain.Episode;
import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

public class PodcastViewModel implements ItemViewModel{
    private final Podcast podcast;

    public PodcastViewModel() {
        this.podcast = new Podcast();
    }

    public PodcastViewModel(Podcast podcast) {
        this.podcast = podcast;
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
