package com.aspsine.podcast.ui.main.featured.item.station;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.Station;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

public class StationViewModel implements ItemViewModel{
    private final Station station;

    public StationViewModel() {
        station = new Station();
    }

    public String getId() {
        return station.getId();
    }

    public String getImage() {
        return station.getImage();
    }

    public void setPodcasts(List<Podcast> podcasts) {
        station.setPodcasts(podcasts);
    }

    public String getName() {
        return station.getName();
    }

    public List<Podcast> getPodcasts() {
        return station.getPodcasts();
    }

    public void setId(String id) {
        station.setId(id);
    }

    public void setName(String name) {
        station.setName(name);
    }

    public void setImage(String image) {
        station.setImage(image);
    }
}
