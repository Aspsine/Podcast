package com.aspsine.podcast.ui.main.discover.item;

import com.aspsine.podcast.domain.Episode;
import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by zhangfan10 on 16/10/8.
 */

public class DiscoverPodcastViewModel implements ItemViewModel{

    private Podcast podcast;

    public DiscoverPodcastViewModel() {
        this.podcast = new Podcast();
    }

    public String getId() {
        return podcast.getId();
    }

    public String getDescription() {
        return podcast.getDescription();
    }

    public void setDescription(String description) {
        podcast.setDescription(description);
    }

    public List<Episode> getEpisodes() {
        return podcast.getEpisodes();
    }

    public void setLastUpdate(String lastUpdate) {
        podcast.setLastUpdate(lastUpdate);
    }

    public void setName(String name) {
        podcast.setName(name);
    }

    public void setEpisodes(List<Episode> episodes) {
        podcast.setEpisodes(episodes);
    }

    public void setArtwork(String artwork) {
        podcast.setArtwork(artwork);
    }

    public String getLastUpdate() {
        return podcast.getLastUpdate();
    }

    public String getStation() {
        return podcast.getStation();
    }

    public void setStation(String station) {
        podcast.setStation(station);
    }

    public void setId(String id) {
        podcast.setId(id);
    }

    public String getName() {
        return podcast.getName();
    }

    public String getArtwork() {
        return podcast.getArtwork();
    }
}
