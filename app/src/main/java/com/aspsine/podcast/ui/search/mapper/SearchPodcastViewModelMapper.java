package com.aspsine.podcast.ui.search.mapper;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.ui.search.item.SearchPodcastViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/10/30.
 */

public class SearchPodcastViewModelMapper {

    public SearchPodcastViewModel transform(Podcast podcast) {
        return new SearchPodcastViewModel(podcast);
    }

    public List<SearchPodcastViewModel> transform(List<Podcast> podcasts) {
        List<SearchPodcastViewModel> podcastViewModels = new ArrayList<>();
        for (Podcast podcast : podcasts) {
            podcastViewModels.add(transform(podcast));
        }
        return podcastViewModels;
    }
}
