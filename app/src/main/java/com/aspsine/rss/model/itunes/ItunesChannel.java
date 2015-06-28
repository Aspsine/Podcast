package com.aspsine.rss.model.itunes;

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

    public String getItunesImage() {
        return itunesImage;
    }

    public void setItunesImage(String itunesImage) {
        this.itunesImage = itunesImage;
    }

    public ItunesOwner getItunesOwner() {
        return itunesOwner;
    }

    public void setItunesOwner(ItunesOwner itunesOwner) {
        this.itunesOwner = itunesOwner;
    }

    public List<String> getItunesCategory() {
        return itunesCategory;
    }

    public void setItunesCategory(List<String> itunesCategory) {
        this.itunesCategory = itunesCategory;
    }

    public String getItunesExplicit() {
        return itunesExplicit;
    }

    public void setItunesExplicit(String itunesExplicit) {
        this.itunesExplicit = itunesExplicit;
    }

    public List<ItunesItem> getItunesItems() {
        return itunesItems;
    }

    public void setItunesItems(List<ItunesItem> itunesItems) {
        this.itunesItems = itunesItems;
    }
}
