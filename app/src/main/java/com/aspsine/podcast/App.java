package com.aspsine.podcast;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.aspsine.podcast.ui.featured.item.banner.BannerViewHolderProvider;
import com.aspsine.podcast.ui.featured.item.banner.BannerViewModel;
import com.aspsine.podcast.ui.featured.item.podcast.PodcastListViewModel;
import com.aspsine.podcast.ui.featured.item.podcast.PodcastListViewHolderProvider;
import com.aspsine.podcast.ui.featured.item.podcast.PodcastViewModel;
import com.aspsine.podcast.ui.featured.item.podcast.PodcastViewHolderProvider;
import com.aspsine.podcast.ui.featured.item.station.StationListViewHolderProvider;
import com.aspsine.podcast.ui.featured.item.station.StationListViewModel;
import com.aspsine.podcast.ui.featured.item.station.StationViewHolderProvider;
import com.aspsine.podcast.ui.featured.item.station.StationViewModel;
import com.aspsine.podcast.ui.featured.item.title.TitleViewHolderProvider;
import com.aspsine.podcast.ui.featured.item.title.TitleViewModel;
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
        BlockCanary.install(this, new AppBlockCanaryContext()).start();

        registerItemProviders();
    }
    
    /**
     * issue: retrofit Memory leak in StrickMode
     * https://github.com/square/retrofit/issues/801
     */
    private void setStrictMode() {
        if (BuildConfig.DEBUG && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.enableDefaults();
        }
    }

    private void registerItemProviders(){
        ItemViewHolderProviderPool.register(BannerViewModel.class, new BannerViewHolderProvider());
        ItemViewHolderProviderPool.register(TitleViewModel.class, new TitleViewHolderProvider());
        ItemViewHolderProviderPool.register(StationViewModel.class, new StationViewHolderProvider());
        ItemViewHolderProviderPool.register(StationListViewModel.class, new StationListViewHolderProvider());
        ItemViewHolderProviderPool.register(PodcastViewModel.class, new PodcastViewHolderProvider());
        ItemViewHolderProviderPool.register(PodcastListViewModel.class, new PodcastListViewHolderProvider());
    }
}
