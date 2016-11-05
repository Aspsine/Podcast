package com.aspsine.podcast.data.source.category;

import com.aspsine.podcast.data.entity.CategoryEntity;
import com.aspsine.podcast.domain.Category;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/11/5.
 */

public interface CategoryDataSource {

    Observable<CategoryEntity> getCategory(String categoryId);

    Observable<List<CategoryEntity>> getCategories();
}