package com.aspsine.podcast.ui.podcast;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.ui.base.BasePresenter;
import com.aspsine.podcast.ui.base.BaseView;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/10/15.
 */

public interface PodcastContract {

    public interface View extends BaseView<Presenter>{
        void startRefresh();

        void stopRefresh();

        void refreshError();

        void bindRefreshData(PodcastViewModel podcastViewModel);
    }

    public interface Presenter extends BasePresenter{

        void refresh();

    }
}
