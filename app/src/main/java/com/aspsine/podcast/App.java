package com.aspsine.podcast;

import android.app.Application;
import android.os.StrictMode;

import com.aspsine.podcast.data.network.OkHttp;
import com.aspsine.podcast.ui.main.discover.item.DiscoverPodcastViewHolderFactory;
import com.aspsine.podcast.ui.main.discover.item.DiscoverPodcastViewModel;
import com.aspsine.podcast.ui.main.featured.item.banner.BannerViewHolderFactory;
import com.aspsine.podcast.ui.main.featured.item.banner.BannerViewModel;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastListViewHolderFactory;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastListViewModel;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastViewHolderFactory;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastViewModel;
import com.aspsine.podcast.ui.main.featured.item.station.StationListViewHolderFactory;
import com.aspsine.podcast.ui.main.featured.item.station.StationListViewModel;
import com.aspsine.podcast.ui.main.featured.item.station.StationViewHolderFactory;
import com.aspsine.podcast.ui.main.featured.item.station.StationViewModel;
import com.aspsine.podcast.ui.main.featured.item.tag.TagListViewHolderFactory;
import com.aspsine.podcast.ui.main.featured.item.tag.TagListViewModel;
import com.aspsine.podcast.ui.main.featured.item.tag.TagViewHolderFactory;
import com.aspsine.podcast.ui.main.featured.item.tag.TagViewModel;
import com.aspsine.podcast.ui.main.featured.item.title.TitleViewHolderFactory;
import com.aspsine.podcast.ui.main.featured.item.title.TitleViewModel;
import com.aspsine.podcast.ui.main.podcasts.item.MyPodcastViewHolderFactory;
import com.aspsine.podcast.ui.main.podcasts.item.MyPodcastViewModel;
import com.aspsine.podcast.ui.podcast.item.EpisodeViewHolderFactory;
import com.aspsine.podcast.ui.podcast.item.EpisodeViewModel;
import com.aspsine.podcast.ui.podcast.item.PodcastHeaderViewHolderFactory;
import com.aspsine.podcast.ui.podcast.item.PodcastHeaderViewModel;
import com.aspsine.podcast.widget.recyclerView.item.GlobalMultiTypeManager;
import com.aspsine.podcast.widget.recyclerView.item.MultiTypeManager;
import com.aspsine.podcast.widget.recyclerView.loadmore.LoadMoreItemViewHolderFactory;
import com.aspsine.podcast.widget.recyclerView.loadmore.LoadMoreViewModel;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Aspsine on 2015/4/13.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        setStrictMode();
        super.onCreate();
        LeakCanary.install(this);
//        BlockCanary.install(this, new AppBlockCanaryContext(getApplicationContext())).start();

        OkHttp.init(this);
        registerItemProviders();
    }
    
    /**
     * issue: retrofit Memory leak in Strict Mode
     * https://github.com/square/retrofit/issues/801
     */
    private void setStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults();
        }
    }

    private void registerItemProviders(){
        GlobalMultiTypeManager.register(LoadMoreViewModel.class, new LoadMoreItemViewHolderFactory());

        GlobalMultiTypeManager.register(BannerViewModel.class, new BannerViewHolderFactory());
        GlobalMultiTypeManager.register(TitleViewModel.class, new TitleViewHolderFactory());
        GlobalMultiTypeManager.register(TagViewModel.class, new TagViewHolderFactory());
        GlobalMultiTypeManager.register(TagListViewModel.class, new TagListViewHolderFactory());
        GlobalMultiTypeManager.register(StationViewModel.class, new StationViewHolderFactory());
        GlobalMultiTypeManager.register(StationListViewModel.class, new StationListViewHolderFactory());
        GlobalMultiTypeManager.register(PodcastViewModel.class, new PodcastViewHolderFactory());
        GlobalMultiTypeManager.register(PodcastListViewModel.class, new PodcastListViewHolderFactory());

        GlobalMultiTypeManager.register(MyPodcastViewModel.class, new MyPodcastViewHolderFactory());

        GlobalMultiTypeManager.register(DiscoverPodcastViewModel.class, new DiscoverPodcastViewHolderFactory());

        GlobalMultiTypeManager.register(PodcastHeaderViewModel.class, new PodcastHeaderViewHolderFactory());
        GlobalMultiTypeManager.register(EpisodeViewModel.class, new EpisodeViewHolderFactory());
    }
}
