package com.aspsine.podcast.data.network;


import android.app.Application;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by aspsine on 15-4-13.
 */
public class OkHttp {

    private static OkHttpClient okHttpClient;

    public static void init(Application app) {
        if (okHttpClient == null) {
            okHttpClient = provideOkHttpClient(app);
        }
    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            throw new NullPointerException("OkHttp#init must be invoked in Application#onCreate().");
        }
        return okHttpClient;
    }

    private static OkHttpClient provideOkHttpClient(Application app) {
        return createOkHttpClient(app).build();
    }

    public static OkHttpClient.Builder createOkHttpClient(Application app) {
        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, 50 * 1024 * 1024);
        return new OkHttpClient.Builder()
                .cache(cache);
    }

    public static Observable<Response> execute(final Request request){
        return Observable.create(new Observable.OnSubscribe<Response>(){

            @Override
            public void call(Subscriber<? super Response> subscriber) {
                if (subscriber.isUnsubscribed()){
                    return;
                }
                try {
                    Response response = getOkHttpClient().newCall(request).execute();
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(response);
                    }
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                } catch (IOException e) {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onError(e);
                    }
                }
            }
        });
    }
}
