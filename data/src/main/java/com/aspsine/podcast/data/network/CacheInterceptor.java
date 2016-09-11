package com.aspsine.podcast.data.network;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by aspsine on 15-4-13.
 */
public class CacheInterceptor implements Interceptor {
    private static final String CACHE_CONTROL = "Cache-Control";

    @Override
    public Response intercept(Chain chain) throws IOException {


        return null;
    }
}
