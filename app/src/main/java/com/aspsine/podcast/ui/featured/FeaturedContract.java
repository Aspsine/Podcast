package com.aspsine.podcast.ui.featured;

import com.aspsine.podcast.ui.base.BasePresenter;
import com.aspsine.podcast.ui.base.BaseView;

/**
 * Created by aspsine on 16/9/11.
 */

public interface FeaturedContract {

    interface View extends BaseView<Presenter> {

        void startRefresh();

        void stopRefresh();

        void refreshError();

        void showLoadMore();

        void stopLoadMore();

        void loadMoreError();
    }

    interface Presenter extends BasePresenter {

        void refresh();

        void loadMore();
    }

}
