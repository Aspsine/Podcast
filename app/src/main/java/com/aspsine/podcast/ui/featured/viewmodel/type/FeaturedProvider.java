package com.aspsine.podcast.ui.featured.viewmodel.type;

import com.aspsine.podcast.domain.Provider;
import com.aspsine.podcast.domain.Station;

import java.util.List;

/**
 * Created by aspsine on 16/9/13.
 */
public class FeaturedProvider {

    private Provider provider;

    public FeaturedProvider() {
        this.provider = new Provider();
    }

    public String getId() {
        return provider.getId();
    }

    public List<Station> getStations() {
        return provider.getStations();
    }

    public void setName(String name) {
        provider.setName(name);
    }

    public String getImage() {
        return provider.getImage();
    }

    public void setStations(List<Station> stations) {
        provider.setStations(stations);
    }

    public void setImage(String image) {
        provider.setImage(image);
    }

    public String getName() {
        return provider.getName();
    }

    public void setId(String id) {
        provider.setId(id);
    }
}
