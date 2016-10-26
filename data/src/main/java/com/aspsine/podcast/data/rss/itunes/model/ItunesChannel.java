package com.aspsine.podcast.data.rss.itunes.model;


import com.aspsine.rss.model.Channel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 15/6/27.
 */
public class ItunesChannel extends Channel {

    public ItunesChannel() {
        itunesItems = new ArrayList<>();
    }

    /**
     * itunes:subtitle
     */
    private String itunesSubtitle;

    /**
     * itunes:author
     */
    private String itunesAuthor;

    /**
     * itunes:summary
     */
    private String itunesSummary;

    /**
     * itunes:owner
     */
    private ItunesOwner itunesOwner;

    /**
     * itunes:image
     */
    private String itunesImage;

    /**
     * itunes:category
     */
    private List<String> itunesCategory;

    /**
     * itunes:explicit
     */
    private String itunesExplicit;

    private String mediaRating;

    /**
     * xmlns:ppg="http://bbc.co.uk/2009/01/ppgRss"
     * ppg:network
     */
    private PPGNetwork ppgNetwork;

    private PPGSeriesDetails ppgSeriesDetails;

    private List<ItunesItem> itunesItems;

    public String getItunesSubtitle() {
        return itunesSubtitle;
    }

    public void setItunesSubtitle(String itunesSubtitle) {
        this.itunesSubtitle = itunesSubtitle;
    }

    public String getItunesAuthor() {
        return itunesAuthor;
    }

    public void setItunesAuthor(String itunesAuthor) {
        this.itunesAuthor = itunesAuthor;
    }

    public String getItunesSummary() {
        return itunesSummary;
    }

    public void setItunesSummary(String itunesSummary) {
        this.itunesSummary = itunesSummary;
    }

    public ItunesOwner getItunesOwner() {
        return itunesOwner;
    }

    public void setItunesOwner(ItunesOwner itunesOwner) {
        this.itunesOwner = itunesOwner;
    }

    public String getItunesImage() {
        return itunesImage;
    }

    public void setItunesImage(String itunesImage) {
        this.itunesImage = itunesImage;
    }

    public List<String> getItunesCategory() {
        return itunesCategory;
    }

    public void setItunesCategory(List<String> itunesCategory) {
        this.itunesCategory = itunesCategory;
    }

    public String getMediaRating() {
        return mediaRating;
    }

    public void setMediaRating(String mediaRating) {
        this.mediaRating = mediaRating;
    }

    public String getItunesExplicit() {
        return itunesExplicit;
    }

    public void setItunesExplicit(String itunesExplicit) {
        this.itunesExplicit = itunesExplicit;
    }

    public PPGNetwork getPpgNetwork() {
        return ppgNetwork;
    }

    public void setPpgNetwork(PPGNetwork ppgNetwork) {
        this.ppgNetwork = ppgNetwork;
    }

    public PPGSeriesDetails getPpgSeriesDetails() {
        return ppgSeriesDetails;
    }

    public void setPpgSeriesDetails(PPGSeriesDetails ppgSeriesDetails) {
        this.ppgSeriesDetails = ppgSeriesDetails;
    }

    public List<ItunesItem> getItunesItems() {
        return itunesItems;
    }

    public void setItunesItems(List<ItunesItem> itunesItems) {
        this.itunesItems = itunesItems;
    }
}
