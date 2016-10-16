package com.aspsine.podcast.ui.podcast.mapper;

import com.aspsine.podcast.domain.Episode;
import com.aspsine.podcast.ui.podcast.item.EpisodeViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/10/16.
 */

public class EpisodeViewModelDataMapper {

    public EpisodeViewModel transform(Episode episode) {
        return new EpisodeViewModel(episode);
    }

    public List<EpisodeViewModel> transform(List<Episode> episodes) {
        List<EpisodeViewModel> episodeViewModels = new ArrayList<>();
        for (Episode episode : episodes) {
            episodeViewModels.add(transform(episode));
        }
        return episodeViewModels;
    }
}
