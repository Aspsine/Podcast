package com.aspsine.podcast.domain.repository;

import com.aspsine.podcast.domain.Podcast;

import java.util.List;

import rx.Observable;

/**
 * Created by aspsine on 16/10/30.
 */

public interface SearchRepository {

    Observable<List<Podcast>> search(String text);

}
