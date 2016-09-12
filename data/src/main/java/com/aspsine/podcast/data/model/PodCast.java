package com.aspsine.podcast.data.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by littlexi on 2015/4/12.
 */
public class Podcast implements Serializable{
    private String id;
    private String name;
    private String lastUpdate;
    private String averageDuration;
    private String description;
    private String artwork;
    private String href;
    private String station;
    private String background;
    private String language;


    private List<PodCastTrack> podCastTracks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(String averageDuration) {
        this.averageDuration = averageDuration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<PodCastTrack> getPodCastTracks() {
        return podCastTracks;
    }

    public void setPodCastTracks(List<PodCastTrack> podCastTracks) {
        this.podCastTracks = podCastTracks;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
