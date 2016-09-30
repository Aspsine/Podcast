package com.aspsine.podcast.ui.main.featured.item.podcast;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

public class PodcastListViewModel implements ItemViewModel {
    private List<PodcastViewModel> podcastViewModels;

    public List<PodcastViewModel> getPodcastViewModels() {
        return podcastViewModels;
    }

    public void setPodcastViewModels(List<PodcastViewModel> podcastViewModels) {
        this.podcastViewModels = podcastViewModels;
    }
}
