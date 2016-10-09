package com.aspsine.podcast.data.entity;

import java.util.List;

/**
 * Created by littlexi on 2015/4/12.
 */
public class SectionEntity {
    List<StationEntity> stations;
    List<StationEntity> genres;

    public SectionEntity(List<StationEntity> stations, List<StationEntity> genres){
        this.stations = stations;
        this.genres = genres;
    }

    public List<StationEntity> getStations() {
        return stations;
    }

    public void setStations(List<StationEntity> stations) {
        this.stations = stations;
    }

    public List<StationEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<StationEntity> genres) {
        this.genres = genres;
    }
}
