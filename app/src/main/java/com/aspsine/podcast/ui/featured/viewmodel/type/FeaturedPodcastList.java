package com.aspsine.podcast.ui.featured.viewmodel.type;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by zhangfan10 on 16/9/13.
 */
public class FeaturedPodcastList implements ItemViewModel{
    private List<FeaturedPodcast> featuredPodcasts;

    public List<FeaturedPodcast> getFeaturedPodcasts() {
        return featuredPodcasts;
    }

    public void setFeaturedPodcasts(List<FeaturedPodcast> featuredPodcasts) {
        this.featuredPodcasts = featuredPodcasts;
    }
}
