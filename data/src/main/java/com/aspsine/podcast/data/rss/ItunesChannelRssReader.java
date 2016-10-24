package com.aspsine.podcast.data.rss;



import com.aspsine.podcast.data.rss.model.itunes.ItunesChannel;
import com.aspsine.podcast.data.rss.parser.sax.ItemsRssHandler;
import com.aspsine.podcast.data.rss.parser.sax.SAXRSSParser;
import com.aspsine.rss.RSSParser;
import com.aspsine.rss.RssReader;

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
                    factory.setNamespaceAware(true);
                    SAXRSSParser parser = new SAXRSSParser<>(factory, new ItemsRssHandler());
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
