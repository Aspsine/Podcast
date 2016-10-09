package com.aspsine.podcast.data.network;

import android.util.Log;

import com.aspsine.podcast.data.entity.PageEntity;
import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.utils.DocumentUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by zhangfan10 on 16/10/9.
 */

public class RestApiImpl implements RestApi {

    @Override
    public Observable<List<PodcastEntity>> getPodcasts(final int page) {
        return Observable.create(new Observable.OnSubscribe<List<PodcastEntity>>() {
            @Override
            public void call(Subscriber<? super List<PodcastEntity>> subscriber) {
                OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
                String url = "http://www.bbc.co.uk/podcasts"+ "?page=" + page;
                Request request = new Request.Builder().url(url).build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    Document document = Jsoup.parse(response.body().string());
                    final PageEntity page = DocumentUtils.getPage(document, false);
                    subscriber.onNext(page.getPodcasts());
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<List<PodcastEntity>> getPodcasts() {
        return null;
    }

    @Override
    public Observable<PodcastEntity> getPodcast(String id) {
        return null;
    }
}
