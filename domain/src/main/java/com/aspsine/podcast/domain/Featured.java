package com.aspsine.podcast.domain;

import java.util.List;

/**
 * Created by aspsine on 16/11/5.
 */

public class Featured {

    private int type;

    public static final int TYPE_BANNERS = 0;

    public static final int TYPE_CATEGORY = 1;

    public static final int TYPE_STATIONS = 2;

    private List<Featured> banners;

    private Category category;

    private List<Station> stations;

    public Featured(int type) {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Featured> getBanners() {
        return banners;
    }

    public void setBanners(List<Featured> banners) {
        this.banners = banners;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
