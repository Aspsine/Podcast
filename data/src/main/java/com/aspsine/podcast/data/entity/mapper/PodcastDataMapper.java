package com.aspsine.podcast.data.entity.mapper;

import com.aspsine.podcast.data.entity.EpisodeEntity;
import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.domain.Episode;
import com.aspsine.podcast.domain.Podcast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan10 on 16/10/9.
 */

public class PodcastDataMapper {

    public Podcast transform(PodcastEntity podcastEntity) {
        Podcast podcast = new Podcast();
        podcast.setId(podcastEntity.getId());
        podcast.setName(podcastEntity.getName());
        podcast.setArtwork(podcastEntity.getArtwork());
        podcast.setDescription(podcastEntity.getDescription());
        podcast.setLastUpdate(podcastEntity.getLastUpdate());
        if (podcastEntity.getEpisodes() != null) {
            List<Episode> episodes = new ArrayList<Episode>();
            for (EpisodeEntity episodeEntity : podcastEntity.getEpisodes()) {
                Episode episode = new Episode();
                episode.setId(episodeEntity.getId());
                episode.setTitle(episodeEntity.getTitle());
                episode.setDescription(episodeEntity.getDescription());
                episode.setArtwork("");
                episode.setPubDate(episodeEntity.getPubDate());
                episodes.add(episode);
            }
            podcast.setEpisodes(episodes);
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
