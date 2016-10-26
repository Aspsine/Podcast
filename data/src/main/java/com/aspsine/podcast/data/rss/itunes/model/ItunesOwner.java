package com.aspsine.podcast.data.rss.itunes.model;

/**
 * Created by aspsine on 15/6/27.
 */
public class ItunesOwner {
    /**
     * itunes:name
     */
    private String itunesName;
    /**
     * itunes:email
     */
    private String itunesEmail;

    public String getItunesName() {
        return itunesName;
    }

    public void setItunesName(String itunesName) {
        this.itunesName = itunesName;
    }

    public String getItunesEmail() {
        return itunesEmail;
    }

    public void setItunesEmail(String itunesEmail) {
        this.itunesEmail = itunesEmail;
    }
}
