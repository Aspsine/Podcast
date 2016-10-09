package com.aspsine.podcast.ui.main.discover.mapper;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.ui.main.discover.item.DiscoverPodcastViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan10 on 16/10/9.
 */

public class DiscoverPodcastViewModelMapper {

    public DiscoverPodcastViewModel transform(Podcast podcast){
        return new DiscoverPodcastViewModel(podcast);
    }

    public List<DiscoverPodcastViewModel> transform(List<Podcast> podcasts) {
        List<DiscoverPodcastViewModel> podcastViewModels = new ArrayList<>();
        for (Podcast podcast : podcasts){
            podcastViewModels.add(transform(podcast));
        }
        return podcastViewModels;
    }

}
