package com.aspsine.podcast.ui.main.discover;

import com.aspsine.podcast.ui.base.BasePresenter;
import com.aspsine.podcast.ui.base.BaseView;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by zhangfan10 on 16/10/8.
 */

public interface DiscoverContract {

    interface Presenter extends BasePresenter {

        void refresh();

        void loadMore();
    }

    interface View extends BaseView<Presenter> {

        void startRefresh();

        void stopRefresh();

        void refreshError();

        void stopLoadMore();

        void loadMoreEnd();

        void loadMoreError();

        void bindRefreshData(List<ItemViewModel> itemViewModels);

        void bindLoadMoreData(List<ItemViewModel> itemViewModels);
    }
}
