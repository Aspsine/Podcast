package com.aspsine.podcast.ui.featured.item.podcast;

import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedPodcast;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

public class PodcastListViewModel implements ItemViewModel {
    private List<FeaturedPodcast> featuredPodcasts;

    public List<FeaturedPodcast> getFeaturedPodcasts() {
        return featuredPodcasts;
    }

    public void setFeaturedPodcasts(List<FeaturedPodcast> featuredPodcasts) {
        this.featuredPodcasts = featuredPodcasts;
    }
}
