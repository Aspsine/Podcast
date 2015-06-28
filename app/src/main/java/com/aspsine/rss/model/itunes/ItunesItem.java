package com.aspsine.rss.model.itunes;

import com.aspsine.rss.model.Item;

/**
 * Created by aspsine on 15/6/27.
 */
public class ItunesItem extends Item {
    /**
     * itunes:author
     */
    private String itunesAuthor;

    /**
     * itunes:subtitle
     */
    private String itunesSubtitle;

    /**
     * html
     * itunes:summary
     */
    private String itunesSummary;

    /**
     * itunes:image
     */
    private String itunesImage;

    /**
     * itunes:duration
     */
    private String itunesDuration;

    public String getItunesAuthor() {
        return itunesAuthor;
    }

    public void setItunesAuthor(String itunesAuthor) {
        this.itunesAuthor = itunesAuthor;
    }

    public String getItunesSubtitle() {
        return itunesSubtitle;
    }

    public void setItunesSubtitle(String itunesSubtitle) {
        this.itunesSubtitle = itunesSubtitle;
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

    public String getItunesDuration() {
        return itunesDuration;
    }

    public void setItunesDuration(String itunesDuration) {
        this.itunesDuration = itunesDuration;
    }
}
