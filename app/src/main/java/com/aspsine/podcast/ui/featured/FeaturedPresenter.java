package com.aspsine.podcast.ui.featured;

import android.os.Handler;
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
        mView.startRefresh();
    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.bindBannerData();
                mView.bindRefreshData();
                mView.stopRefresh();
            }
        }, 2000);
    }

    @Override
    public void loadMore() {
        mView.showLoadMore();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.bindLoadMoreData();

            }
        }, 1000);
    }

    @Override
    public void onBannerItemClick(int position) {

    }
}
