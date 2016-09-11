package com.aspsine.podcast.data.model;

import java.util.List;

/**
 * Created by aspsine on 15-4-12.
 */
public class Page {
    private List<Podcast> podcasts;
    private boolean isParsePageInfo;
    private int pageSize;
    private int podCastNum;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPodCastNum() {
        return podCastNum;
    }

    public void setPodCastNum(int podCastNum) {
        this.podCastNum = podCastNum;
    }

    public List<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    public boolean isParsePageInfo() {
        return isParsePageInfo;
    }

    public void setIsParsePageInfo(boolean isParsePageInfo) {
        this.isParsePageInfo = isParsePageInfo;
    }
}
