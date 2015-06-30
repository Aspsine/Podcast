package com.aspsine.podcast.model;

import java.io.Serializable;

/**
 * Created by Aspsine on 2015/6/23.
 */
public class PodCastTrack implements Serializable{
    String title;
    String link;
    String description;
    String pubDate;
    String duration;
    String size;

    public PodCastTrack(){}

    public PodCastTrack(String title, String link, String description, String pubDate, String duration, String size) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.duration = duration;
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
