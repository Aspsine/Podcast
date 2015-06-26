package com.aspsine.podcast.network;

import android.content.Context;

import com.aspsine.podcast.App;
import com.aspsine.podcast.Constants;
import com.aspsine.podcast.util.FileUtils;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by aspsine on 15-4-13.
 */
public class OkHttp {
    private static OkHttpClient okHttpClient;

    public static OkHttpClient createHttpClient() {
        if (okHttpClient == null) {
            synchronized (OkHttp.class) {
                okHttpClient = new OkHttpClient();
                okHttpClient.setCache(new Cache(FileUtils.getHttpCacheDir(App.getContext()), Constants.Config.HTTP_CACHE_SIZE));
                okHttpClient.setConnectTimeout(Constants.Config.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
                okHttpClient.setReadTimeout(Constants.Config.HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS);
                okHttpClient.networkInterceptors().add(new CacheInterceptor());
//                okHttpClient.setFollowRedirects(true);
            }
        }
        return okHttpClient;
    }
}
