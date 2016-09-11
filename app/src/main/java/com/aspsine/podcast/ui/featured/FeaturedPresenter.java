package com.aspsine.podcast.ui.featured;

import android.support.annotation.NonNull;

import static com.facebook.common.internal.Preconditions.checkNotNull;

/**
 * Created by aspsine on 16/9/11.
 */

public class FeaturedPresenter implements FeaturedContract.Presenter {

    private FeaturedContract.View mView;

    private int mPage;

    public FeaturedPresenter(@NonNull FeaturedContract.View view) {
        this.mView = checkNotNull(view);
    }

    @Override
    public void start() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {
        mView.showLoadMore();

    }
}
