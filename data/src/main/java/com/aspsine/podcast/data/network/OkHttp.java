package com.aspsine.podcast.data.network;


import android.app.Application;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

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

    public static OkHttpClient provideOkHttpClient(Application app) {
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
                try {
                    Response response = getOkHttpClient().newCall(request).execute();
                    subscriber.onNext(response);
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
