package com.aspsine.rss.parser.sax;

import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by aspsine on 15/6/27.
 */
public abstract class RssHandler<T> extends DefaultHandler {

    public abstract T rss();

}
