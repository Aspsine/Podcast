package com.aspsine.rss.model;

import java.util.List;

/**
 * Created by aspsine on 15/6/27.
 * http://www.w3cschool.cc/rss/rss-channel.html
 * http://www.rssboard.org/rss-specification
 */
public class Channel {

    /**
     * must
     *
     * The name of the channel. It's how people refer to your service. If you have an HTML website that contains the same information as your RSS file, the title of your channel should be the same as the title of your website.
     */
    protected String title;

    /**
     * must
     *
     * The URL to the HTML website corresponding to the channel.
     */
    protected String link;

    /**
     * must
     *
     * Phrase or sentence describing the channel.
     */
    protected String description;

    /**
     * Specify one or more categories that the channel belongs to. Follows the same rules as the <item>-level category element. More info.
     */
    protected List<String> category;

    /**
     * Allows processes to register with a cloud to be notified of updates to the channel, implementing a lightweight publish-subscribe protocol for RSS feeds. More info here.
     */
    protected String cloud;

    /**
     * Copyright notice for content in the channel.
     */
    protected String copyright;

    /**
     * A URL that points to the documentation for the format used in the RSS file. It's probably a pointer to this page. It's for people who might stumble across an RSS file on a Web server 25 years from now and wonder what it is.
     */
    protected String docs;

    /**
     * A string indicating the program used to generate the channel.
     */
    protected String generator;

    /**
     * Specifies a GIF, JPEG or PNG image that can be displayed with the channel. More info here.
     */
    protected Image image;

    /**
     * The language the channel is written in. This allows aggregators to group all Italian language sites, for example, on a single page. A list of allowable values for this element, as provided by Netscape, is here. You may also use values defined by the W3C.
     */
    protected String language;

    /**
     * The last time the content of the channel changed.
     */
    protected String lastBuildDate;

    /**
     * Email address for person responsible for editorial content.
     */
    protected String managingEditor;

    /**
     * The publication date for the content in the channel. For example, the New York Times publishes on a daily basis, the publication date flips once every 24 hours. That's when the pubDate of the channel changes. All date-times in RSS conform to the Date and Time Specification of RFC 822, with the exception that the year may be expressed with two characters or four characters (four preferred).
     */
    protected String pubDate;

    /**
     * The PICS rating for the channel.
     */
    protected String rating;

    /**
     * A hint for aggregators telling them which days they can skip. This element contains up to seven <day> sub-elements whose value is Monday, Tuesday, Wednesday, Thursday, Friday, Saturday or Sunday. Aggregators may not read the channel during days listed in the <skipDays> element.
     */
    protected String skipDays;

    /**
     * A hint for aggregators telling them which hours they can skip. This element contains up to 24 <hour> sub-elements whose value is a number between 0 and 23, representing a time in GMT, when aggregators, if they support the feature, may not read the channel on hours listed in the <skipHours> element. The hour beginning at midnight is hour zero.
     */
    protected String skipHours;

    /**
     * Specifies a text input box that can be displayed with the channel. More info here.
     */
    protected String textInput;

    /**
     * ttl stands for time to live. It's a number of minutes that indicates how long a channel can be cached before refreshing from the source. More info here.
     */
    protected String ttl;

    /**
     * Email address for person responsible for technical issues relating to channel.
     */
    protected String webMaster;

    /**
     * item list
     */
    protected List<Item> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getManagingEditor() {
        return managingEditor;
    }

    public void setManagingEditor(String managingEditor) {
        this.managingEditor = managingEditor;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSkipDays() {
        return skipDays;
    }

    public void setSkipDays(String skipDays) {
        this.skipDays = skipDays;
    }

    public String getSkipHours() {
        return skipHours;
    }

    public void setSkipHours(String skipHours) {
        this.skipHours = skipHours;
    }

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getWebMaster() {
        return webMaster;
    }

    public void setWebMaster(String webMaster) {
        this.webMaster = webMaster;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
