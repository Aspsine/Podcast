package com.aspsine.podcast.network;

import com.aspsine.rss.model.itunes.ItunesChannel;
import com.aspsine.rss.parser.RSSParser;
import com.aspsine.rss.parser.sax.ItunesRssHandler;
import com.aspsine.rss.parser.sax.SAXRSSParser;
import com.aspsine.rss.RssReader;

import java.io.InputStream;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by aspsine on 15/6/28.
 */
public class OkHttpRssReader extends RssReader<ItunesChannel> {
    private static OkHttpRssReader rssReader = null;


    public static OkHttpRssReader getInstance() {
        if (rssReader == null) {
            synchronized (OkHttpRssReader.class) {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                ItunesRssHandler handler = new ItunesRssHandler();
                factory.setNamespaceAware(true);
                SAXRSSParser parser = new SAXRSSParser<ItunesChannel>(factory, handler);
                rssReader = new OkHttpRssReader(parser);
            }
        }
        return rssReader;
    }

    private OkHttpRssReader(RSSParser parser) {
        super(parser);
    }

}
