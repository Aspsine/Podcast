package com.aspsine.rss.parser;

import java.io.InputStream;

/**
 * Created by aspsine on 15/6/27.
 */
public interface RSSParser<T> {
    T parse(InputStream inputStream);
}
