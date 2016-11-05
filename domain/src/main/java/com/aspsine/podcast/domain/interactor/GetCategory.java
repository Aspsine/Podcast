package com.aspsine.podcast.domain.interactor;

import com.aspsine.podcast.domain.Category;
import com.aspsine.podcast.domain.repository.CategoryRepository;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by aspsine on 16/11/5.
 */

public class GetCategory extends UseCase<Category> {

    private String mCategoryId;

    private CategoryRepository mCategoryRepository;

    public GetCategory(String categoryId, CategoryRepository categoryRepository, Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        super(subscribeOnScheduler, observeOnScheduler);
        this.mCategoryId = categoryId;
        this.mCategoryRepository = categoryRepository;
    }

    @Override
    public Observable<Category> buildUseCaseObservable() {
        return mCategoryRepository.getCategory(mCategoryId);
    }
}
