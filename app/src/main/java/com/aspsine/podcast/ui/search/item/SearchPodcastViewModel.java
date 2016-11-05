package com.aspsine.podcast.ui.search.item;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

/**
 * Created by aspsine on 16/10/30.
 */

public class SearchPodcastViewModel implements ItemViewModel {

    private Podcast podcast;

    public SearchPodcastViewModel() {
        podcast = new Podcast();
    }

    public SearchPodcastViewModel(Podcast podcast) {
        this.podcast = podcast;
    }

    public String getId() {
        return podcast.getId();
    }

    public String getName() {
        return podcast.getName();
    }

    public String getArtwork() {
        return podcast.getArtwork();
    }

    public String getStation() {
        return podcast.getStation();
    }

    public String getDescription() {
        return podcast.getDescription();
    }
}
