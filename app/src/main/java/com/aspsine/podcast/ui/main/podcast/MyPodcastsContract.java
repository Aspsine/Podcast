package com.aspsine.podcast.ui.main.podcast;

import com.aspsine.podcast.ui.base.BasePresenter;
import com.aspsine.podcast.ui.base.BaseView;

import java.util.List;

/**
 * Created by zhangfan10 on 16/9/30.
 */

public interface MyPodcastsContract {

    interface View extends BaseView<Presenter> {
        void bindData(List<MyPodcastViewModel> myPodcastViewModels);
    }

    interface Presenter extends BasePresenter {

    }

}
