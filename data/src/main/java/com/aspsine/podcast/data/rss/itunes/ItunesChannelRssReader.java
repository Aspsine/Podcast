package com.aspsine.podcast.data.rss.itunes;



import com.aspsine.podcast.data.rss.itunes.model.ItunesChannel;
import com.aspsine.rss.parser.sax.SAXRSSParser;
import com.aspsine.rss.RssReader;

import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by aspsine on 15/6/28.
 */
public class ItunesChannelRssReader implements RssReader<ItunesChannel> {

    private final SAXRSSParser<ItunesChannel> parser;
    private static ItunesChannelRssReader sInstance;

    public static ItunesChannelRssReader getInstance() {
        if (sInstance == null) {
            synchronized (ItunesChannelRssReader.class) {
                if (sInstance == null) {
                    sInstance = new ItunesChannelRssReader();
                }
            }
        }
        return sInstance;
    }

    private ItunesChannelRssReader() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        this.parser = new SAXRSSParser<>(factory, new ItunesChannelRssHandler());
    }

    @Override
    public ItunesChannel load(InputStream inputStream) {
        return parser.parse(inputStream);
    }
}
