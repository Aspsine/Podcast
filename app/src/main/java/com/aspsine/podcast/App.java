package com.aspsine.podcast;

import android.app.Application;
import android.os.StrictMode;

import com.aspsine.podcast.data.network.OkHttp;
import com.aspsine.podcast.ui.main.discover.item.DiscoverPodcastViewHolderProvider;
import com.aspsine.podcast.ui.main.discover.item.DiscoverPodcastViewModel;
import com.aspsine.podcast.ui.main.featured.item.banner.BannerViewHolderProvider;
import com.aspsine.podcast.ui.main.featured.item.banner.BannerViewModel;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastListViewHolderProvider;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastListViewModel;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastViewHolderProvider;
import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastViewModel;
import com.aspsine.podcast.ui.main.featured.item.station.StationListViewHolderProvider;
import com.aspsine.podcast.ui.main.featured.item.station.StationListViewModel;
import com.aspsine.podcast.ui.main.featured.item.station.StationViewHolderProvider;
import com.aspsine.podcast.ui.main.featured.item.station.StationViewModel;
import com.aspsine.podcast.ui.main.featured.item.tag.TagListViewHolderProvider;
import com.aspsine.podcast.ui.main.featured.item.tag.TagListViewModel;
import com.aspsine.podcast.ui.main.featured.item.tag.TagViewHolderProvider;
import com.aspsine.podcast.ui.main.featured.item.tag.TagViewModel;
import com.aspsine.podcast.ui.main.featured.item.title.TitleViewHolderProvider;
import com.aspsine.podcast.ui.main.featured.item.title.TitleViewModel;
import com.aspsine.podcast.ui.main.podcasts.item.MyPodcastViewHolderProvider;
import com.aspsine.podcast.ui.main.podcasts.item.MyPodcastViewModel;
import com.aspsine.podcast.ui.podcast.item.EpisodeViewHolderProvider;
import com.aspsine.podcast.ui.podcast.item.EpisodeViewModel;
import com.aspsine.podcast.ui.podcast.item.PodcastHeaderViewHolderProvider;
import com.aspsine.podcast.ui.podcast.item.PodcastHeaderViewModel;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderProviderPool;
import com.aspsine.podcast.widget.recyclerView.loadmore.LoadMoreViewHolderProvider;
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
        ItemViewHolderProviderPool.register(LoadMoreViewModel.class, new LoadMoreViewHolderProvider());

        ItemViewHolderProviderPool.register(BannerViewModel.class, new BannerViewHolderProvider());
        ItemViewHolderProviderPool.register(TitleViewModel.class, new TitleViewHolderProvider());
        ItemViewHolderProviderPool.register(TagViewModel.class, new TagViewHolderProvider());
        ItemViewHolderProviderPool.register(TagListViewModel.class, new TagListViewHolderProvider());
        ItemViewHolderProviderPool.register(StationViewModel.class, new StationViewHolderProvider());
        ItemViewHolderProviderPool.register(StationListViewModel.class, new StationListViewHolderProvider());
        ItemViewHolderProviderPool.register(PodcastViewModel.class, new PodcastViewHolderProvider());
        ItemViewHolderProviderPool.register(PodcastListViewModel.class, new PodcastListViewHolderProvider());

        ItemViewHolderProviderPool.register(MyPodcastViewModel.class, new MyPodcastViewHolderProvider());

        ItemViewHolderProviderPool.register(DiscoverPodcastViewModel.class, new DiscoverPodcastViewHolderProvider());

        ItemViewHolderProviderPool.register(PodcastHeaderViewModel.class, new PodcastHeaderViewHolderProvider());
        ItemViewHolderProviderPool.register(EpisodeViewModel.class, new EpisodeViewHolderProvider());
    }
}
