package com.aspsine.podcast.data.rss;



import com.aspsine.podcast.data.rss.model.itunes.ItunesChannel;
import com.aspsine.podcast.data.rss.parser.RSSParser;
import com.aspsine.podcast.data.rss.parser.sax.ItunesRssHandler;
import com.aspsine.podcast.data.rss.parser.sax.SAXRSSParser;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by aspsine on 15/6/28.
 */
public class ItunesChannelRssReader extends RssReader<ItunesChannel> {
    private static ItunesChannelRssReader rssReader = null;

    public static ItunesChannelRssReader getInstance() {
        if (rssReader == null) {
            synchronized (ItunesChannelRssReader.class) {
                if (rssReader == null) {
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    ItunesRssHandler handler = new ItunesRssHandler();
                    factory.setNamespaceAware(true);
                    SAXRSSParser parser = new SAXRSSParser<ItunesChannel>(factory, handler);
                    rssReader = new ItunesChannelRssReader(parser);
                }
            }
        }
        return rssReader;
    }

    private ItunesChannelRssReader(RSSParser parser) {
        super(parser);
    }

}
