package com.aspsine.podcast.data.source.featured;

import com.aspsine.podcast.data.entity.FeaturedEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/11/5.
 */

public interface FeaturedDataSource {

    Observable<List<FeaturedEntity>> getFeatureds();
}
