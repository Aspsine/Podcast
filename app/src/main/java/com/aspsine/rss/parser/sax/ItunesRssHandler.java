package com.aspsine.rss.parser.sax;

import android.text.TextUtils;

import com.aspsine.podcast.util.L;
import com.aspsine.rss.model.Enclosure;
import com.aspsine.rss.model.Image;
import com.aspsine.rss.model.itunes.ItunesChannel;
import com.aspsine.rss.model.itunes.ItunesItem;
import com.aspsine.rss.model.itunes.ItunesOwner;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aspsine on 15/6/28.
 */
public class ItunesRssHandler extends RssHandler<ItunesChannel> {
    private ItunesChannel mChannel;

    Map<String, Attributes> map = new HashMap<>();

    @Override
    public ItunesChannel rss() {
        return mChannel;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        mChannel = new ItunesChannel();
        L.i("ItunesRssHandler", "startDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        L.i("ItunesRssHandler", "startElement: " + "uri = " + uri + "; localName = " + localName + "; qName = " + qName);
        map.put(qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        if (TextUtils.isEmpty(value)){
            return;
        }
        if (map.containsKey("title")){
            mChannel.setTitle(value);
        }else if (map.containsKey("link")){
            mChannel.setLink(value);
        }else if (map.containsKey("description")){
            mChannel.setDescription(value);
        }else if (map.containsKey("itunes:summary")){
            mChannel.setItunesSummary(value);
        }else if (map.containsKey("itunes:author")){
            mChannel.setItunesAuthor(value);
        }else if (map.containsKey("itunes:owner")){
            if (mChannel.getItunesOwner() == null){
                ItunesOwner owner = new ItunesOwner();
                mChannel.setItunesOwner(owner);
            }
            if (map.containsKey("itunes:name")){
                mChannel.getItunesOwner().setItunesName(value);
            }else if (map.containsKey("itunes:email")){
                mChannel.getItunesOwner().setItunesEmail(value);
            }
        }else if (map.containsKey("language")){
            mChannel.setLanguage(value);
        }else if (map.containsKey("image")){
            if (mChannel.getImage() == null){
                Image image = new Image();
                mChannel.setImage(image);
            }
            if (map.containsKey("url")){
                mChannel.getImage().setUrl(value);
            }else if (map.containsKey("title")){
                mChannel.getImage().setTitle(value);
            }else if (map.containsKey("link")){
                mChannel.getImage().setLink(value);
            }
        }else if (map.containsKey("itunes:image")){
            mChannel.setItunesImage(value);
        }else if (map.containsKey("copyright")){
            mChannel.setCopyright(value);
        }else if (map.containsKey("pubDate")){
            mChannel.setPubDate(value);
        }else if (map.containsKey("itunes:category")) {
            if (mChannel.getCategory()== null){
                List<String> category = new ArrayList<>();
                mChannel.setCategory(category);
            }
            Attributes attributes = map.get("itunes:category");
            String category = attributes.getValue(attributes.getIndex("itunes:category"));
            mChannel.getCategory().add(category);
        }else if (map.containsKey("itunes:explicit")){
            mChannel.setItunesExplicit(value);
        }else if (map.containsKey("item")){
            if (mChannel.getItems() == null){
                List<ItunesItem> items = new ArrayList<>();
                mChannel.setItunesItems(items);
            }
            ItunesItem item = new ItunesItem();
            if (map.containsKey("title")){
                item.setTitle(value);
            }else if (map.containsKey("description")){
                item.setDescription(value);
            }else if (map.containsKey("itunes:subtitle")){
                item.setItunesSubtitle(value);
            }else if (map.containsKey("itunes:summary")){
                item.setItunesSummary(value);
            }else if (map.containsKey("pubDate")){
                item.setPubDate(value);
            }else if (map.containsKey("itunes:duration")){
                item.setItunesDuration(value);
            }else if (map.containsKey("enclosure")){
                if (item.getEnclosure() == null){
                    Enclosure enclosure = new Enclosure();
                    item.setEnclosure(enclosure);
                }
                Attributes attributes = map.get("enclosure");
                item.getEnclosure().setUrl(attributes.getValue(attributes.getIndex("url")));
                item.getEnclosure().setLength(attributes.getValue(attributes.getIndex("length")));
                item.getEnclosure().setType(attributes.getValue(attributes.getIndex("type")));
            }else if (map.containsKey("guid")){
                item.setGuid(value);
            }else if (map.containsKey("link")){
                item.setLink(value);
            }else if (map.containsKey("itunes:author")){
                item.setItunesAuthor(value);
            }
            mChannel.getItunesItems().add(item);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        L.i("ItunesRssHandler", "endElement: " + "uri = " + uri + "; localName = " + localName + "; qName = " + qName);
        map.remove(qName);
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        L.i("ItunesRssHandler", "endDocument");
    }
}
