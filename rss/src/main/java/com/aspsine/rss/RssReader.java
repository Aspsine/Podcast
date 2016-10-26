package com.aspsine.rss;

import java.io.InputStream;

/**
 * Created by aspsine on 15/6/27.
 */
public interface RssReader<T> {

    T load(InputStream inputStream);
}
