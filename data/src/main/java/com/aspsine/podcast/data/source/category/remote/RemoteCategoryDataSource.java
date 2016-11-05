package com.aspsine.podcast.data.source.category.remote;

import com.aspsine.podcast.data.entity.CategoryEntity;
import com.aspsine.podcast.data.network.RestApi;
import com.aspsine.podcast.data.source.category.CategoryDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/11/5.
 */

public class RemoteCategoryDataSource implements CategoryDataSource {

    private RestApi mRestApi;

    public RemoteCategoryDataSource(RestApi restApi) {
        this.mRestApi = restApi;
    }

    @Override
    public Observable<CategoryEntity> getCategory(String categoryId) {
        return mRestApi.getCategory(categoryId);
    }

    @Override
    public Observable<List<CategoryEntity>> getCategories() {
        return mRestApi.getCategories();
    }
}