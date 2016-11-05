package com.aspsine.podcast.data.source.featured;

import com.aspsine.podcast.data.source.category.CategoryDataSourceFactory;
import com.aspsine.podcast.data.source.featured.remote.RemoteFeaturedDataSource;
import com.aspsine.podcast.data.source.station.StationDataSourceFactory;

/**
 * Created by aspsine on 16/11/5.
 */
public class FeaturedDataSourceFactory {

    public RemoteFeaturedDataSource createRemoteFeaturedDataSource() {
        final CategoryDataSourceFactory categoryDataSourceFactory = new CategoryDataSourceFactory();
        final StationDataSourceFactory stationDataSourceFactory = new StationDataSourceFactory();
        return new RemoteFeaturedDataSource(categoryDataSourceFactory, stationDataSourceFactory);
    }
}
