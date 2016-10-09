package com.aspsine.podcast.data.entity;

import java.util.List;

/**
 * Created by aspsine on 15-4-12.
 */
public class PageEntity {
    private List<PodcastEntity> podcasts;
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

    public List<PodcastEntity> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<PodcastEntity> podcasts) {
        this.podcasts = podcasts;
    }

    public boolean isParsePageInfo() {
        return isParsePageInfo;
    }

    public void setIsParsePageInfo(boolean isParsePageInfo) {
        this.isParsePageInfo = isParsePageInfo;
    }
}
