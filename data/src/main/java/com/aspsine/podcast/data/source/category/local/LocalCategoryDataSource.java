package com.aspsine.podcast.data.source.category.local;

import com.aspsine.podcast.data.entity.CategoryEntity;
import com.aspsine.podcast.data.source.category.CategoryDataSource;
import com.aspsine.podcast.domain.Category;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/11/5.
 */

public class LocalCategoryDataSource implements CategoryDataSource{


    @Override
    public Observable<CategoryEntity> getCategory(String categoryId) {
        return null;
    }

    @Override
    public Observable<List<CategoryEntity>> getCategories() {
        return null;
    }
}