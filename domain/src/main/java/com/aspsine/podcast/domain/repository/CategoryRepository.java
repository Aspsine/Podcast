package com.aspsine.podcast.domain.repository;

import com.aspsine.podcast.domain.Category;

import java.util.List;

import rx.Observable;


/**
 * Created by aspsine on 16/9/12.
 */

public interface CategoryRepository {

    Observable<Category> getCategory(String id);

    Observable<List<Category>> getCategories();
}
