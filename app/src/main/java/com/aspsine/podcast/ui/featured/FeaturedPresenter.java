package com.aspsine.podcast.ui.featured;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.aspsine.podcast.ui.featured.item.banner.BannerViewModel;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/11.
 */

public class FeaturedPresenter implements FeaturedContract.Presenter {

    private FeaturedContract.View mView;

    private int mPage;

    public FeaturedPresenter(@NonNull FeaturedContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        mView.startRefresh();
        refresh();
    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.bindRefreshData(getMockedRefreshItems());
                mView.stopRefresh();
            }
        }, 2000);
    }

    @Override
    public void loadMore() {
        mView.startLoadMore();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.bindLoadMoreData(getMockedLoadMoreItems());
            }
        }, 1000);
    }

    private BannerViewModel getMockedBanner(){
        BannerViewModel bannerViewModel = new BannerViewModel();
        List<ItemViewModel> itemViewModels = new ArrayList<>();

        return null;
    }


    private List<ItemViewModel> getMockedRefreshItems(){
        return null;
    }

    private List<ItemViewModel> getMockedLoadMoreItems(){
        return null;
    }
}
