package com.aspsine.podcast.ui.main.discover;

import com.aspsine.podcast.ui.main.discover.item.DiscoverPodcastViewModel;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan10 on 16/10/8.
 */

public class DiscoverPresenter implements DiscoverContract.Presenter {

    private final DiscoverContract.View mView;

    public DiscoverPresenter(DiscoverContract.View view) {
        this.mView = view;
    }

    @Override
    public void start() {
        mView.startRefresh();
        refresh();
    }

    @Override
    public void refresh() {
        mView.bindRefreshData(getMockedRefreshData());
        mView.stopRefresh();
    }

    @Override
    public void loadMore() {

    }

    public List<ItemViewModel> getMockedRefreshData() {
        List<ItemViewModel> itemViewModels = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            DiscoverPodcastViewModel podcastViewModel = new DiscoverPodcastViewModel();
            podcastViewModel.setId(String.valueOf(i));
            podcastViewModel.setName("Learning English Drama " + i);
            podcastViewModel.setLastUpdate(i + "MINs");
            podcastViewModel.setArtwork("http://ichef.bbci.co.uk/images/ic/176x176/p02tq1mm.jpg");
            podcastViewModel.setDescription("People, places and stories that make Northern Ireland unique, with Anne Marie McAleese.");
            itemViewModels.add(podcastViewModel);
        }
        return itemViewModels;
    }
}
