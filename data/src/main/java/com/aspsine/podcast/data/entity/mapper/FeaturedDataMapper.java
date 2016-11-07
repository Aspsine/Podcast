package com.aspsine.podcast.data.entity.mapper;

import com.aspsine.podcast.data.entity.CategoryEntity;
import com.aspsine.podcast.data.entity.FeaturedEntity;
import com.aspsine.podcast.data.entity.StationEntity;
import com.aspsine.podcast.domain.Category;
import com.aspsine.podcast.domain.Featured;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/11/5.
 */

public class FeaturedDataMapper {
    private StationDataMapper mStationDataMapper;

    private CategoryDataMapper mCategoryDataMapper;

    public FeaturedDataMapper() {
        mStationDataMapper = new StationDataMapper();
        mCategoryDataMapper = new CategoryDataMapper();
    }

    public List<Featured> transform(List<FeaturedEntity> featuredEntities) {
        List<Featured> featureds = new ArrayList<>();
        for (FeaturedEntity featuredEntity : featuredEntities){
            featureds.add(transform(featuredEntity));
        }
        return featureds;
    }

    public Featured transform(FeaturedEntity featuredEntity){
        Featured featured = new Featured();
        switch (featuredEntity.getType()){
            case FeaturedEntity.TYPE_FEATURED_STATION_LIST:
                featured.setType(Featured.TYPE_STATIONS);
                List<StationEntity> stationEntities = featuredEntity.getStationEntities();
                featured.setStations(mStationDataMapper.transform(stationEntities));
                return featured;
            case FeaturedEntity.TYPE_FEATURED_CATEGORY:
                featured.setType(Featured.TYPE_CATEGORY);
                CategoryEntity categoryEntity = featuredEntity.getCategoryEntity();
                featured.setCategory(mCategoryDataMapper.transform(categoryEntity));
                return featured;
        }
        return null;
    }
}
