package com.aspsine.podcast.data.entity.mapper;

import com.aspsine.podcast.data.entity.StationEntity;
import com.aspsine.podcast.domain.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/11/6.
 */

public class StationDataMapper {

    PodcastDataMapper mPodcastDataMapper;

    public StationDataMapper() {
        mPodcastDataMapper = new PodcastDataMapper();
    }

    public List<Station> transform(List<StationEntity> stationEntities) {
        List<Station> stations = new ArrayList<>();
        for (StationEntity stationEntity : stationEntities) {
            stations.add(transform(stationEntity));
        }
        return stations;
    }

    public Station transform(StationEntity stationEntity) {
        Station station = new Station();
        station.setId(stationEntity.getId());
        station.setName(stationEntity.getName());
        station.setImage(stationEntity.getImage());
        if (stationEntity.getPodcastEntities() != null) {
            station.setPodcasts(mPodcastDataMapper.transform(stationEntity.getPodcastEntities()));
        }
        return station;
    }
}
