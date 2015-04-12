package com.aspsine.podcast.model;

import java.util.List;

/**
 * Created by littlexi on 2015/4/12.
 */
public class Sections {
    List<Station> stataions;
    List<Station> genres;

    public Sections(List<Station> stataions, List<Station> genres){
        this.stataions = stataions;
        this.genres = genres;
    }

    public List<Station> getStataions() {
        return stataions;
    }

    public void setStataions(List<Station> stataions) {
        this.stataions = stataions;
    }

    public List<Station> getGenres() {
        return genres;
    }

    public void setGenres(List<Station> genres) {
        this.genres = genres;
    }
}
