package com.aspsine.podcast.data.network;

import com.aspsine.podcast.data.entity.CategoryEntity;
import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.entity.StationEntity;

import java.util.List;

import rx.Observable;
import rx.Observer;

/**
 * Created by aspsine on 16/10/8.
 */

public interface RestApi {

    Observable<List<PodcastEntity>> getPodcasts(int page);

    Observable<List<PodcastEntity>> getPodcasts();

    Observable<PodcastEntity> getPodcast(String id);

    Observable<List<PodcastEntity>> search(String text);

    Observable<CategoryEntity> getCategory(String categoryId);

    Observable<List<CategoryEntity>> getCategories();

    Observable<StationEntity> getStation(String id);

    Observable<List<StationEntity>> getStations();
}
