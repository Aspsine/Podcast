package com.aspsine.podcast.data.network;

import com.aspsine.podcast.data.entity.PageEntity;
import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.utils.DocumentUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zhangfan10 on 16/10/9.
 */

public class RestApiImpl implements RestApi {

    public static final String BASE_URL = "http://www.bbc.co.uk/podcasts";

    @Override
    public Observable<List<PodcastEntity>> getPodcasts(final int page) {
        final String url = BASE_URL + "?page=" + page;
        return OkHttp.execute(new Request.Builder().url(url).get().build())
                .flatMap(new Func1<Response, Observable<List<PodcastEntity>>>() {

                    @Override
                    public Observable<List<PodcastEntity>> call(final Response response) {

                        return Observable.create(new Observable.OnSubscribe<List<PodcastEntity>>() {
                            @Override
                            public void call(Subscriber<? super List<PodcastEntity>> subscriber) {
                                try {
                                    Document document = Jsoup.parse(response.body().string());
                                    final PageEntity page = DocumentUtils.getPage(document, false);
                                    subscriber.onNext(page.getPodcasts());
                                    subscriber.onCompleted();
                                } catch (IOException e) {
                                    subscriber.onError(e);
                                }
                            }
                        });
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
