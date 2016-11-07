package com.aspsine.podcast.data.entity.mapper;

import com.aspsine.podcast.data.entity.EpisodeEntity;
import com.aspsine.podcast.domain.Episode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan10 on 16/10/9.
 */

public class EpisodeDataMapper {

    public Episode transform(EpisodeEntity episodeEntity){
        Episode episode = new Episode();
        episode.setId(episodeEntity.getId());
        episode.setTitle(episodeEntity.getTitle());
        episode.setDescription(episodeEntity.getDescription());
        episode.setArtwork(episodeEntity.getArtwork());
        episode.setPubDate(episodeEntity.getPubDate());
        return episode;
    }

    public List<Episode> transform(List<EpisodeEntity> episodeEntities){
        List<Episode> episodes = new ArrayList<>();
        for (EpisodeEntity episodeEntity : episodeEntities){
            episodes.add(transform(episodeEntity));
        }
        return episodes;
    }

}
