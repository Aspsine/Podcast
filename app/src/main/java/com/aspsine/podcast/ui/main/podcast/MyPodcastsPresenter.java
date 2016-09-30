package com.aspsine.podcast.ui.main.podcast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan10 on 16/9/30.
 */

public class MyPodcastsPresenter implements MyPodcastsContract.Presenter {

    MyPodcastsContract.View mView;

    public MyPodcastsPresenter(MyPodcastsContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        mView.bindData(getMockedData());
    }

    public List<MyPodcastViewModel> getMockedData() {
        List<MyPodcastViewModel> myPodcastViewModels = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            MyPodcastViewModel myPodcastViewModel = new MyPodcastViewModel();
            myPodcastViewModel.setId(String.valueOf(i));
            myPodcastViewModel.setName("Learning English");
            myPodcastViewModel.setArtwork("http://ichef.bbci.co.uk/images/ic/224x224/p02h1m9n.jpg");
            myPodcastViewModel.setLastUpdateTime("9月"+i+"日");
            myPodcastViewModels.add(myPodcastViewModel);
        }
        return myPodcastViewModels;
    }

}
