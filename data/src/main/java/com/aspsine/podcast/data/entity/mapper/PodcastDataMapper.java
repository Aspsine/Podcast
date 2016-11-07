package com.aspsine.podcast.data.entity.mapper;

import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.domain.Podcast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan10 on 16/10/9.
 */

public class PodcastDataMapper {

    private EpisodeDataMapper mEpisodeDataMapper;

    public PodcastDataMapper() {
        mEpisodeDataMapper = new EpisodeDataMapper();
    }

    public Podcast transform(PodcastEntity podcastEntity) {
        Podcast podcast = new Podcast();
        podcast.setId(podcastEntity.getId());
        podcast.setName(podcastEntity.getName());
        podcast.setArtwork(podcastEntity.getArtwork());
        podcast.setDescription(podcastEntity.getDescription());
        podcast.setLastUpdate(podcastEntity.getLastUpdate());
        if (podcastEntity.getEpisodes() != null) {
            podcast.setEpisodes(mEpisodeDataMapper.transform(podcastEntity.getEpisodes()));
        }
        return podcast;
    }


    public List<Podcast> transform(List<PodcastEntity> podcastEntities) {
        List<Podcast> podcasts = new ArrayList<>();
        for (PodcastEntity podcastEntity : podcastEntities) {
            podcasts.add(transform(podcastEntity));
        }
        return podcasts;
    }
}
