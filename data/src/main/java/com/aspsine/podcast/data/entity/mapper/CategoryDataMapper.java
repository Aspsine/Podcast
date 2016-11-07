package com.aspsine.podcast.data.entity.mapper;

import com.aspsine.podcast.data.entity.CategoryEntity;
import com.aspsine.podcast.domain.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/11/6.
 */

public class CategoryDataMapper {

    private PodcastDataMapper mPodcastDataMapper;

    public CategoryDataMapper() {
        mPodcastDataMapper = new PodcastDataMapper();
    }

    public List<Category> transfrom(List<CategoryEntity> categoryEntities) {
        List<Category> categories = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            categories.add(transform(categoryEntity));
        }
        return categories;
    }

    public Category transform(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        if (categoryEntity.getPodcastEntities() != null) {
            category.setPodcasts(mPodcastDataMapper.transform(categoryEntity.getPodcastEntities()));
        }
        return category;
    }
}
