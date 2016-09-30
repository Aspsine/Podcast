package com.aspsine.podcast;

import android.app.Application;
import android.os.StrictMode;

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
import com.aspsine.podcast.ui.main.podcast.MyPodcastViewHolderProvider;
import com.aspsine.podcast.ui.main.podcast.MyPodcastViewModel;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderProviderPool;
import com.github.moduth.blockcanary.BlockCanary;
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
        BlockCanary.install(this, new AppBlockCanaryContext(getApplicationContext())).start();

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
        ItemViewHolderProviderPool.register(BannerViewModel.class, new BannerViewHolderProvider());
        ItemViewHolderProviderPool.register(TitleViewModel.class, new TitleViewHolderProvider());
        ItemViewHolderProviderPool.register(TagViewModel.class, new TagViewHolderProvider());
        ItemViewHolderProviderPool.register(TagListViewModel.class, new TagListViewHolderProvider());
        ItemViewHolderProviderPool.register(StationViewModel.class, new StationViewHolderProvider());
        ItemViewHolderProviderPool.register(StationListViewModel.class, new StationListViewHolderProvider());
        ItemViewHolderProviderPool.register(PodcastViewModel.class, new PodcastViewHolderProvider());
        ItemViewHolderProviderPool.register(PodcastListViewModel.class, new PodcastListViewHolderProvider());

        ItemViewHolderProviderPool.register(MyPodcastViewModel.class, new MyPodcastViewHolderProvider());
    }
}
