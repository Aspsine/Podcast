package com.aspsine.podcast.data.rss.itunes.model;


import com.aspsine.rss.model.Item;

/**
 * xmlns:itunes="http://www.itunes.com/dtds/podcast-1.0.dtd"
 *
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

    private String itunesExplicit;

    private MediaContent mediaContent;

    private String ppgCanonical;

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

    public String getItunesExplicit() {
        return itunesExplicit;
    }

    public void setItunesExplicit(String itunesExplicit) {
        this.itunesExplicit = itunesExplicit;
    }

    public MediaContent getMediaContent() {
        return mediaContent;
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.mediaContent = mediaContent;
    }

    public String getPpgCanonical() {
        return ppgCanonical;
    }

    public void setPpgCanonical(String ppgCanonical) {
        this.ppgCanonical = ppgCanonical;
    }
}
