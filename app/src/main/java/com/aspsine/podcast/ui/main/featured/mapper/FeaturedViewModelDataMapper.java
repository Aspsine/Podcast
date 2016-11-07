package com.aspsine.podcast.ui.main.featured.mapper;

import com.aspsine.podcast.domain.Category;
import com.aspsine.podcast.domain.Featured;
import com.aspsine.podcast.domain.Station;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastListViewModel;
import com.aspsine.podcast.ui.main.featured.item.station.StationListViewModel;
import com.aspsine.podcast.ui.main.featured.item.title.TitleViewModel;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/11/6.
 */

public class FeaturedViewModelDataMapper {

    private PodcastListViewModelDataMapper mPodcastListViewModelDataMapper;

    private StationListViewModelDataMapper mStationListViewModelDataMapper;

    public FeaturedViewModelDataMapper() {
        mPodcastListViewModelDataMapper = new PodcastListViewModelDataMapper();
        mStationListViewModelDataMapper = new StationListViewModelDataMapper();
    }

    public List<ItemViewModel> transform(List<Featured> featureds) {
        List<ItemViewModel> itemViewModels = new ArrayList<>();
        for (Featured featured : featureds) {
            switch (featured.getType()) {
                case Featured.TYPE_CATEGORY:
                    Category category = featured.getCategory();
                    TitleViewModel titleViewModel = new TitleViewModel();
                    titleViewModel.setText(category.getName());
                    itemViewModels.add(titleViewModel);
                    PodcastListViewModel podcastListViewModel = mPodcastListViewModelDataMapper.transform(category.getPodcasts());
                    itemViewModels.add(podcastListViewModel);
                    break;
                case Featured.TYPE_STATIONS:
                    List<Station> stations = featured.getStations();
                    StationListViewModel stationListViewModel = mStationListViewModelDataMapper.transform(stations);
                    itemViewModels.add(stationListViewModel);
                    break;
            }
        }
        return itemViewModels;
    }


}
