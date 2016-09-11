package com.aspsine.podcast.domain.repository;

import com.aspsine.podcast.domain.Station;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/9/12.
 */

public interface StationRepository {

    Observable<Station> station(String id);

    Observable<List<Station>> stations();

}
