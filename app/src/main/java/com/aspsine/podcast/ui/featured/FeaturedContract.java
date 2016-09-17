package com.aspsine.podcast.ui.featured;

import com.aspsine.podcast.ui.base.BasePresenter;
import com.aspsine.podcast.ui.base.BaseView;
import com.aspsine.podcast.ui.featured.viewmodel.FeaturedItem;

import java.util.List;

/**
 * Created by aspsine on 16/9/11.
 */

public interface FeaturedContract {

    interface View extends BaseView<Presenter> {

        void startRefresh();

        void bindRefreshData(List<FeaturedItem> featuredItems);

        void bindLoadMoreData(List<FeaturedItem> featuredItems);

        void stopRefresh();

        void refreshError();

        void startLoadMore();

        void stopLoadMore();

        void loadMoreError();
    }

    interface Presenter extends BasePresenter {

        void refresh();

        void loadMore();
    }

}
