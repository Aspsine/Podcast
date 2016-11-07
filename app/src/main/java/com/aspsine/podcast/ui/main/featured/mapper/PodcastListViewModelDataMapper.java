package com.aspsine.podcast.ui.main.featured.mapper;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastListViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/11/6.
 */

public class PodcastListViewModelDataMapper {

    private PodcastViewModelDataMapper mPodcastViewModelDataMapper;

    public PodcastListViewModelDataMapper() {
        mPodcastViewModelDataMapper = new PodcastViewModelDataMapper();
    }

    public PodcastListViewModel transform(List<Podcast> podcasts){
        return new PodcastListViewModel(mPodcastViewModelDataMapper.transform(podcasts));
    }
}
