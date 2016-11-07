package com.aspsine.podcast.ui.main.featured.mapper;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/11/6.
 */

public class PodcastViewModelDataMapper {

    public List<PodcastViewModel> transform(List<Podcast> podcasts){
        List<PodcastViewModel> podcastViewModels = new ArrayList<>();
        for (Podcast podcast : podcasts){
            podcastViewModels.add(transform(podcast));
        }
        return podcastViewModels;
    }

    public PodcastViewModel transform(Podcast podcast){
        return new PodcastViewModel(podcast);
    }
}
