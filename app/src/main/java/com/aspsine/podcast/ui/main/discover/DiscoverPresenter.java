package com.aspsine.podcast.ui.main.discover;

import android.os.Handler;
import android.os.Looper;

import com.aspsine.podcast.data.model.Page;
import com.aspsine.podcast.data.model.Podcast;
import com.aspsine.podcast.ui.main.discover.item.DiscoverPodcastViewModel;
import com.aspsine.podcast.util.DocumentUtils;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhangfan10 on 16/10/8.
 */

public class DiscoverPresenter implements DiscoverContract.Presenter {

    private final DiscoverContract.View mView;

    private int mPage;

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
        mPage = 1;
        loadRefreshData();
    }

    @Override
    public void loadMore() {
        loadRefreshData();
    }

    private List<ItemViewModel> getMockedRefreshData() {
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

    private Handler handler = new Handler(Looper.getMainLooper());

    private void loadRefreshData() {
        String url = "http://www.bbc.co.uk/podcasts?page=" + mPage;
        final Request request = new Request.Builder().get().url(url).build();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Document document = Jsoup.parse(response.body().string());

                final Page page = DocumentUtils.getPage(document, mPage == 1);
                final List<Podcast> podcasts = page.getPodcasts();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        List<ItemViewModel> itemViewModels = new ArrayList<>();
                        for (Podcast podcast : podcasts) {
                            DiscoverPodcastViewModel podcastViewModel = new DiscoverPodcastViewModel();
                            podcastViewModel.setId(podcast.getHref());
                            podcastViewModel.setArtwork(podcast.getArtwork());
                            podcastViewModel.setName(podcast.getName());
                            podcastViewModel.setLastUpdate(podcast.getLastUpdate());
                            podcastViewModel.setDescription(podcast.getDescription());
                            itemViewModels.add(podcastViewModel);
                        }
                        if (mPage == 1) {
                            mPage++;
                            mView.stopRefresh();
                            mView.bindRefreshData(itemViewModels);
                        } else {
                            mPage++;
                            mView.stopLoadMore();
                            mView.bindLoadMoreData(itemViewModels);
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });


    }

}
