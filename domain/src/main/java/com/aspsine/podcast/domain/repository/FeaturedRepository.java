package com.aspsine.podcast.domain.repository;

import com.aspsine.podcast.domain.Featured;
import com.aspsine.podcast.domain.Station;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/9/12.
 */

public interface FeaturedRepository {

    Observable<List<Featured>> getFeatureds();

}
