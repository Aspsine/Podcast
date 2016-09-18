package com.aspsine.podcast.ui.featured;

import com.aspsine.podcast.ui.base.BasePresenter;
import com.aspsine.podcast.ui.base.BaseView;
import com.aspsine.podcast.ui.featured.viewmodel.FeaturedItem;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/11.
 */

public interface FeaturedContract {

    interface View extends BaseView<Presenter> {

        void startRefresh();

        void bindRefreshData(List<ItemViewModel> itemViewModels);

        void bindLoadMoreData(List<ItemViewModel> itemViewModels);

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
