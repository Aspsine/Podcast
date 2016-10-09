package com.aspsine.podcast.data.repository;

import com.aspsine.podcast.domain.Category;
import com.aspsine.podcast.domain.repository.CategoryRepository;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/9/12.
 */

public class CategoryDataRepository implements CategoryRepository {

    @Override
    public Observable<Category> getCategory(String id) {
        return null;
    }

    @Override
    public Observable<List<Category>> getCategories() {
        return null;
    }
}
