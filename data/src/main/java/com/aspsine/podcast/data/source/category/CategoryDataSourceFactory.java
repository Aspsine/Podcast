package com.aspsine.podcast.data.source.category;

import com.aspsine.podcast.data.network.RestApi;
import com.aspsine.podcast.data.network.RestApiImpl;
import com.aspsine.podcast.data.source.category.remote.RemoteCategoryDataSource;

/**
 * Created by aspsine on 16/11/5.
 */

public class CategoryDataSourceFactory {

    public RemoteCategoryDataSource createRemoteCategoryDataSource() {
        RestApi restApi = new RestApiImpl();
        return new RemoteCategoryDataSource(restApi);
    }
}