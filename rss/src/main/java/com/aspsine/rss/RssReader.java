package com.aspsine.rss;

import java.io.InputStream;

/**
 * Created by aspsine on 15/6/27.
 */
public class RssReader<T> {
    private RSSParser<T> mParser;

    public RssReader(RSSParser parser) {
        this.mParser = parser;
    }

    public T load(InputStream inputStream) {
        T t = mParser.parse(inputStream);
        return t;
    }
}
