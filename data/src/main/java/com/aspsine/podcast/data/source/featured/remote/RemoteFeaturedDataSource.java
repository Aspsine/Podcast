package com.aspsine.podcast.data.source.featured.remote;

import com.aspsine.podcast.data.entity.CategoryEntity;
import com.aspsine.podcast.data.entity.FeaturedEntity;
import com.aspsine.podcast.data.entity.StationEntity;
import com.aspsine.podcast.data.source.category.CategoryDataSource;
import com.aspsine.podcast.data.source.category.CategoryDataSourceFactory;
import com.aspsine.podcast.data.source.featured.FeaturedDataSource;
import com.aspsine.podcast.data.source.station.StationDataSource;
import com.aspsine.podcast.data.source.station.StationDataSourceFactory;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by aspsine on 16/11/5.
 */

public class RemoteFeaturedDataSource implements FeaturedDataSource {

    private final CategoryDataSourceFactory mCategoryDataSourceFactory;

    private final StationDataSourceFactory mStationDataSourceFactory;

    public RemoteFeaturedDataSource(CategoryDataSourceFactory categoryDataSourceFactory, StationDataSourceFactory stationDataSourceFactory) {
        this.mCategoryDataSourceFactory = categoryDataSourceFactory;
        this.mStationDataSourceFactory = stationDataSourceFactory;
    }

    @Override
    public Observable<List<FeaturedEntity>> getFeatureds() {

        return Observable.zip(getCategories(), getStations(), new Func2<List<FeaturedEntity>, FeaturedEntity, List<FeaturedEntity>>() {
            @Override
            public List<FeaturedEntity> call(List<FeaturedEntity> featuredEntities, FeaturedEntity featuredEntity) {
                featuredEntities.add(0, featuredEntity);
                return featuredEntities;
            }
        });
    }

    private Observable<List<FeaturedEntity>> getCategories() {

        final CategoryDataSource categoryDataSource = mCategoryDataSourceFactory.createRemoteCategoryDataSource();
        return categoryDataSource.getCategories().flatMap(new Func1<List<CategoryEntity>, Observable<CategoryEntity>>() {
            @Override
            public Observable<CategoryEntity> call(List<CategoryEntity> categoryEntities) {
                return Observable.from(categoryEntities);
            }
        }).flatMap(new Func1<CategoryEntity, Observable<CategoryEntity>>() {
            @Override
            public Observable<CategoryEntity> call(final CategoryEntity categoryEntity1) {
                return categoryDataSource.getCategory(categoryEntity1.getId()).map(new Func1<CategoryEntity, CategoryEntity>() {
                    @Override
                    public CategoryEntity call(CategoryEntity categoryEntity) {
                        categoryEntity.setName(categoryEntity1.getName());
                        return categoryEntity;
                    }
                });
            }
        }).map(new Func1<CategoryEntity, FeaturedEntity>() {
            @Override
            public FeaturedEntity call(CategoryEntity categoryEntity) {
                FeaturedEntity featuredEntity = new FeaturedEntity();
                featuredEntity.setType(FeaturedEntity.TYPE_FEATURED_CATEGORY);
                featuredEntity.setCategoryEntity(categoryEntity);
                return featuredEntity;
            }
        }).toList();
    }

    private Observable<FeaturedEntity> getStations() {

        final StationDataSource stationDataSource = mStationDataSourceFactory.createRemoteStationDataSource();
        return stationDataSource.getStations().map(new Func1<List<StationEntity>, FeaturedEntity>() {
            @Override
            public FeaturedEntity call(List<StationEntity> stationEntities) {
                FeaturedEntity featuredEntity = new FeaturedEntity();
                featuredEntity.setType(FeaturedEntity.TYPE_FEATURED_STATION_LIST);
                featuredEntity.setStationEntities(stationEntities);
                return featuredEntity;
            }
        });
    }
}
