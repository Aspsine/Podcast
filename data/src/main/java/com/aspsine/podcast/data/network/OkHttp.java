package com.aspsine.podcast.data.network;


import android.app.Application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

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
                .cache(cache)
                .addInterceptor(new CacheInterceptor());
    }

    public static Observable<Response> execute(final Request request) {
        return Observable.create(new Observable.OnSubscribe<Response>() {

            @Override
            public void call(Subscriber<? super Response> subscriber) {
                if (subscriber.isUnsubscribed()) {
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

    public static Observable<InputStream> inputStream(final Request request) {
        return execute(request).map(new Func1<Response, InputStream>() {
            @Override
            public InputStream call(Response response) {
                if (response.isSuccessful()) {
                    return response.body().byteStream();
                } else {
                    throw error(response);
                }
            }
        });
    }

    public static Observable<String> string(final Request request) {
        return execute(request).map(new Func1<Response, String>() {
            @Override
            public String call(Response response) {
                if (response.isSuccessful()) {
                    try {
                        return response.body().string();
                    } catch (IOException e) {
                        throw Exceptions.propagate(e);
                    }
                } else {
                    throw error(response);
                }
            }
        });
    }

    private static RuntimeException error(Response response) {
        try {
            return new RuntimeException("Http request Error [code:" + response.code() + "; " + "message:" + response.body().string() + "]");
        } catch (Exception e) {
            return Exceptions.propagate(e);
        }
    }
}
