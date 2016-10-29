package com.aspsine.rss.parser.sax;


import com.aspsine.rss.parser.RSSParser;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by aspsine on 15/6/27.
 */
public class SAXRSSParser<T> implements RSSParser<T> {
    private SAXParserFactory factory;
    private RssHandler<T> rssHandler;

    public SAXRSSParser(SAXParserFactory factory, RssHandler<T> handler) {
        this.factory = factory;
        this.rssHandler = handler;
    }

    @Override
    public T parse(InputStream inputStream) {
        InputSource source = new InputSource(inputStream);
        try {
            return parse(source, rssHandler);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public T parse(InputSource source, RssHandler<T> handler) throws IOException, SAXException, ParserConfigurationException {
        XMLReader xmlReader = factory.newSAXParser().getXMLReader();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(source);
        return handler.rss();
    }


}
