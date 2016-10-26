package com.aspsine.podcast.data.rss.itunes;

import android.util.Log;


import com.aspsine.podcast.data.rss.itunes.model.ItunesChannel;
import com.aspsine.podcast.data.rss.itunes.model.ItunesItem;
import com.aspsine.podcast.data.rss.itunes.model.ItunesOwner;
import com.aspsine.podcast.data.rss.itunes.model.MediaContent;
import com.aspsine.podcast.data.rss.itunes.model.PPGNetwork;
import com.aspsine.podcast.data.rss.itunes.model.PPGSeriesDetails;
import com.aspsine.rss.parser.sax.RssHandler;
import com.aspsine.rss.model.Enclosure;
import com.aspsine.rss.model.Image;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by aspsine on 16/10/23.
 */

public class ItunesChannelRssHandler extends RssHandler<ItunesChannel> {

    private ItunesChannel itunesChannel;

    private StringBuilder currentValue = new StringBuilder();

    private Stack<String> tagStack = new Stack<>();

    @Override
    public ItunesChannel rss() {
        return itunesChannel;
    }

    @Override
    public void startDocument() throws SAXException {
        Log.i("MItemsRssHandler", "startDocument ");
        tagStack.push("");
    }

    @Override
    public void endDocument() throws SAXException {
        Log.i("MItemsRssHandler", "endDocument ");
        tagStack.clear();
        currentValue.setLength(0);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tagStack.push(qName);
        currentValue.setLength(0);

        if (qName.equals("channel")) {

            itunesChannel = new ItunesChannel();

        } else if (qName.equals("itunes:owner")) {

            ItunesOwner itunesOwner = new ItunesOwner();
            itunesChannel.setItunesOwner(itunesOwner);

        } else if (qName.equals("ppg:seriesDetails")) {

            PPGSeriesDetails ppgSeriesDetails = new PPGSeriesDetails();
            // frequency
            ppgSeriesDetails.setFrequency(attributes.getValue("frequency"));
            // daysLive
            ppgSeriesDetails.setDaysLive(attributes.getValue("daysLive"));
            itunesChannel.setPpgSeriesDetails(ppgSeriesDetails);

        } else if (qName.equals("ppg:network")) {

            PPGNetwork ppgNetwork = new PPGNetwork();
            // station id
            ppgNetwork.setId(attributes.getValue("id"));
            // station name
            ppgNetwork.setName(attributes.getValue("name"));
            itunesChannel.setPpgNetwork(ppgNetwork);

        } else if (qName.equals("image")) {

            Image image = new Image();
            itunesChannel.setImage(image);

        } else if (qName.equals("itunes:image")) {
            // 图片
            itunesChannel.setItunesImage(attributes.getValue(attributes.getIndex("href")));
        } else if (qName.equals("itunes:category")) {
            List<String> category = itunesChannel.getCategory();
            if (category == null) {
                category = new ArrayList<>();
                itunesChannel.setItunesCategory(category);
            }
            category.add(attributes.getValue("text"));
        } else if (qName.equals("item")) {
            if (itunesChannel.getItunesItems() == null) {
                itunesChannel.setItunesItems(new ArrayList<ItunesItem>());
            }
            itunesChannel.getItunesItems().add(new ItunesItem());
        } else if (qName.equals("enclosure")) {
            if (itunesChannel.getItunesItems() != null) {
                Enclosure enclosure = new Enclosure();
                enclosure.setUrl(attributes.getValue("url"));
                enclosure.setLength(attributes.getValue("length"));
                enclosure.setType(attributes.getValue("type"));
                getLastItem().setEnclosure(enclosure);
            }
        } else if (qName.equals("media:content")) {
            if (itunesChannel.getItunesItems() != null) {
                MediaContent mediaContent = new MediaContent();
                mediaContent.setUrl(attributes.getValue("url"));
                mediaContent.setFileSize(attributes.getValue("fileSize"));
                mediaContent.setType(attributes.getValue("type"));
                mediaContent.setMedium(attributes.getValue("medium"));
                mediaContent.setExpression(attributes.getValue("expression"));
                mediaContent.setDuration(attributes.getValue("duration"));
                getLastItem().setMediaContent(mediaContent);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String tag = tagStack.peek();
        if (!qName.equals(tag)) {
            throw new InternalError();
        }
        tagStack.pop();
        String parentTag = tagStack.peek();
        if (parentTag.equals("channel")) {
            if (tag.equals("title")) {
                itunesChannel.setTitle(currentValue.toString());
            } else if (tag.equals("link")) {
                itunesChannel.setLink(currentValue.toString());
            } else if (tag.equals("description")) {
                itunesChannel.setDescription(currentValue.toString());
            } else if (tag.equals("itunes:summary")) {
                itunesChannel.setItunesSummary(currentValue.toString());
            } else if (tag.equals("language")) {
                itunesChannel.setLanguage(currentValue.toString());
            } else if (tag.equals("copyright")) {
                itunesChannel.setCopyright(currentValue.toString());
            } else if (tag.equals("pubDate")) {
                itunesChannel.setPubDate(currentValue.toString());
            } else if (tag.equals("itunes:explicit")) {
                itunesChannel.setItunesExplicit(currentValue.toString());
            } else if (tag.equals("media:rating")) {
                itunesChannel.setMediaRating(currentValue.toString());
            }
        } else if (parentTag.equals("itunes:owner")) {
            if (tag.equals("itunes:name")) {
                itunesChannel.getItunesOwner().setItunesName(currentValue.toString());
            } else if (tag.equals("itunes:email")) {
                itunesChannel.getItunesOwner().setItunesEmail(currentValue.toString());
            }
        } else if (parentTag.equals("image")) {
            if (tag.equals("url")) {
                itunesChannel.getImage().setUrl(currentValue.toString());
            } else if (tag.equals("title")) {
                itunesChannel.getImage().setTitle(currentValue.toString());
            } else if (tag.equals("link")) {
                itunesChannel.getImage().setLink(currentValue.toString());
            }
        } else if (parentTag.equals("item")) {
            if (tag.equals("title")) {
                getLastItem().setTitle(currentValue.toString());
            } else if (tag.equals("description")) {
                getLastItem().setDescription(currentValue.toString());
            } else if (tag.equals("itunes:subtitle")) {
                getLastItem().setItunesSubtitle(currentValue.toString());
            } else if (tag.equals("itunes:summary")) {
                getLastItem().setItunesSummary(currentValue.toString());
            } else if (tag.equals("pubDate")) {
                getLastItem().setPubDate(currentValue.toString());
            } else if (tag.equals("itunes:duration")) {
                getLastItem().setItunesDuration(currentValue.toString());
            } else if (tag.equals("guid")) {
                getLastItem().setGuid(currentValue.toString());
            } else if (tag.equals("link")) {
                getLastItem().setLink(currentValue.toString());
            } else if (tag.equals("itunes:explicit")) {
                getLastItem().setItunesExplicit(currentValue.toString());
            } else if (tag.equals("itunes:author")) {
                getLastItem().setItunesAuthor(currentValue.toString());
            } else if (tag.equals("ppg:canonical")) {
                getLastItem().setPpgCanonical(currentValue.toString());
            }
        }
    }

    private ItunesItem getLastItem() {
        return itunesChannel.getItunesItems().get(itunesChannel.getItunesItems().size() - 1);
    }

}
