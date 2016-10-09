package com.aspsine.podcast.data.rss.parser.sax;

import android.text.TextUtils;
import android.util.Log;

import com.aspsine.podcast.data.rss.model.itunes.ItunesItem;
import com.aspsine.podcast.data.rss.model.Enclosure;
import com.aspsine.podcast.data.rss.model.Image;
import com.aspsine.podcast.data.rss.model.itunes.ItunesChannel;
import com.aspsine.podcast.data.rss.model.itunes.ItunesOwner;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aspsine on 15/6/28.
 * <p/>
 * transform is not suit the case, we must use stack!!! fuck!! I miss JDom!!!
 */
public class ItunesRssHandler extends RssHandler<ItunesChannel> {
    private ItunesChannel mChannel;

    private ItunesItem mItem;

    private String mCurrentElement;

    private Map<String, Map<String, String>> map = new HashMap<>();

    @Override
    public ItunesChannel rss() {
        return mChannel;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        mChannel = new ItunesChannel();
        Log.i("ItunesRssHandler", "startDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        Log.i("ItunesRssHandler", "startElement: " + "uri = " + uri + "; localName = " + localName + "; qName = " + qName);
        Map<String, String> attrMap = new HashMap<>();
        for (int i = 0; i < attributes.getLength(); i++) {
            String key = attributes.getQName(i);
            String value = attributes.getValue(i);
            attrMap.put(key, value);
        }
        map.put(qName, attrMap);
        mCurrentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        if (TextUtils.isEmpty(value) || TextUtils.isEmpty(mCurrentElement)) {
            return;
        }
        if (map.containsKey("title") && !map.containsKey("image") && !map.containsKey("item")) {
            mChannel.setTitle(value);
        } else if (map.containsKey("link") && !map.containsKey("image") && !map.containsKey("item")) {
            mChannel.setLink(value);
        } else if (map.containsKey("description") && !map.containsKey("item")) {
            mChannel.setDescription(value);
        } else if (map.containsKey("itunes:summary") && !map.containsKey("item")) {
            mChannel.setItunesSummary(value);
        } else if (map.containsKey("itunes:author") && !map.containsKey("item")) {
            mChannel.setItunesAuthor(value);
        } else if (map.containsKey("itunes:owner")) {
            if (mChannel.getItunesOwner() == null) {
                ItunesOwner owner = new ItunesOwner();
                mChannel.setItunesOwner(owner);
            }
            if (map.containsKey("itunes:name")) {
                mChannel.getItunesOwner().setItunesName(value);
            } else if (map.containsKey("itunes:email")) {
                mChannel.getItunesOwner().setItunesEmail(value);
            }
        } else if (map.containsKey("language")) {
            mChannel.setLanguage(value);
        } else if (map.containsKey("image")) {
            if (mChannel.getImage() == null) {
                Image image = new Image();
                mChannel.setImage(image);
            }
            if (map.containsKey("url")) {
                mChannel.getImage().setUrl(value);
            } else if (map.containsKey("title")) {
                mChannel.getImage().setTitle(value);
            } else if (map.containsKey("link")) {
                mChannel.getImage().setLink(value);
            }
        } else if (map.containsKey("itunes:image")) {
            mChannel.setItunesImage(value);
        } else if (map.containsKey("copyright")) {
            mChannel.setCopyright(value);
        } else if (map.containsKey("pubDate") && !map.containsKey("item")) {
            mChannel.setPubDate(value);
        } else if (map.containsKey("itunes:explicit")) {
            mChannel.setItunesExplicit(value);
        } else if (map.containsKey("item")) {
            if (mChannel.getItems() == null) {
                List<ItunesItem> items = new ArrayList<>();
                mChannel.setItunesItems(items);
            }
            if (mCurrentElement.equals("item")) {
                mItem = new ItunesItem();
            }
            if (map.containsKey("title")) {
                mItem.setTitle(value);
            } else if (map.containsKey("description")) {
                mItem.setDescription(value);
            } else if (map.containsKey("itunes:subtitle")) {
                mItem.setItunesSubtitle(value);
            } else if (map.containsKey("itunes:summary")) {
                mItem.setItunesSummary(value);
            } else if (map.containsKey("pubDate")) {
                mItem.setPubDate(value);
            } else if (map.containsKey("itunes:duration")) {
                mItem.setItunesDuration(value);
            } else if (map.containsKey("guid")) {
                mItem.setGuid(value);
            } else if (map.containsKey("link")) {
                mItem.setLink(value);
            } else if (map.containsKey("itunes:author")) {
                mItem.setItunesAuthor(value);
            }

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        Log.i("ItunesRssHandler", "endElement: " + "uri = " + uri + "; localName = " + localName + "; qName = " + qName);
        if (qName.equals("item")) {
            mChannel.getItunesItems().add(mItem);
        } else if (qName.equals("enclosure") && map.containsKey("enclosure")) {
            if (mItem.getEnclosure() == null) {
                Enclosure enclosure = new Enclosure();
                mItem.setEnclosure(enclosure);
            }
            Map<String, String> attrMap = map.get("enclosure");
            mItem.getEnclosure().setUrl(attrMap.get("url"));
            mItem.getEnclosure().setLength(attrMap.get("length"));
            mItem.getEnclosure().setType(attrMap.get("type"));
        } else if (qName.equals("itunes:category") && map.containsKey("itunes:category")) {
            if (mChannel.getCategory() == null) {
                List<String> category = new ArrayList<>();
                mChannel.setItunesCategory(category);
            }
            Map<String, String> attrMap = map.get("itunes:category");
            String category = attrMap.get("text");
            mChannel.getItunesCategory().add(category);
        }
        map.remove(qName);
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        Log.i("ItunesRssHandler", "endDocument ");
    }
}
