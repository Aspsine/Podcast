package com.aspsine.podcast.model;

import java.util.List;

/**
 * Created by aspsine on 15-4-12.
 */
public class Page {
    private List<PodCast> podCasts;
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

    public List<PodCast> getPodCasts() {
        return podCasts;
    }

    public void setPodCasts(List<PodCast> podCasts) {
        this.podCasts = podCasts;
    }

    public boolean isParsePageInfo() {
        return isParsePageInfo;
    }

    public void setIsParsePageInfo(boolean isParsePageInfo) {
        this.isParsePageInfo = isParsePageInfo;
    }
}
