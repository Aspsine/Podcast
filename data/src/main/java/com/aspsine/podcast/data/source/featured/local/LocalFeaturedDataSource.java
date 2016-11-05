package com.aspsine.podcast.data.source.featured.local;

import com.aspsine.podcast.data.entity.FeaturedEntity;
import com.aspsine.podcast.data.source.featured.FeaturedDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/11/5.
 */

public class LocalFeaturedDataSource implements FeaturedDataSource{

    @Override
    public Observable<List<FeaturedEntity>> getFeatureds() {
        return null;
    }
}
