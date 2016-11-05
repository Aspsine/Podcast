package com.aspsine.podcast.data.repository;

import com.aspsine.podcast.data.entity.FeaturedEntity;
import com.aspsine.podcast.data.entity.mapper.FeaturedDataMapper;
import com.aspsine.podcast.data.source.featured.FeaturedDataSource;
import com.aspsine.podcast.data.source.featured.FeaturedDataSourceFactory;
import com.aspsine.podcast.domain.Featured;
import com.aspsine.podcast.domain.repository.FeaturedRepository;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by aspsine on 16/11/5.
 */

public class FeaturedDataRepository implements FeaturedRepository {

    private FeaturedDataMapper mFeaturedDataMapper;

    private FeaturedDataSourceFactory mFeaturedDataSourceFactory;

    public FeaturedDataRepository(FeaturedDataMapper mapper, FeaturedDataSourceFactory factory) {
        this.mFeaturedDataMapper = mapper;
        this.mFeaturedDataSourceFactory = factory;
    }

    @Override
    public Observable<List<Featured>> getFeatureds() {
        FeaturedDataSource featuredDataSource = mFeaturedDataSourceFactory.createRemoteFeaturedDataSource();
        return featuredDataSource.getFeatureds().map(new Func1<List<FeaturedEntity>, List<Featured>>() {
            @Override
            public List<Featured> call(List<FeaturedEntity> featuredEntities) {
                return mFeaturedDataMapper.transform(featuredEntities);
            }
        });
    }
}
