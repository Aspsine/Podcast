package com.aspsine.rss.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 15/6/27.
 * http://www.w3cschool.cc/rss/rss-channel.html
 */
public class Channel {

    public Channel(){
        items = new ArrayList<>();
    }

    /**
     * must
     *
     */
    protected String title;

    /**
     * must
     */
    protected String link;

    /**
     * must
     */
    protected String description;

    /**
     *
     */
    protected List<String> category;

    /**
     *
     */
    protected String cloud;

    /**
     *
     */
    protected String copyright;

    /**
     *
     */
    protected String docs;

    /**
     *
     */
    protected String generator;

    /**
     *
     */
    protected Image image;

    /**
     *
     */
    protected String language;

    /**
     *
     */
    protected String lastBuildDate;

    /**
     *
     */
    protected String managingEditor;

    /**
     *
     */
    protected String pubDate;

    /**
     *
     */
    protected String rating;

    /**
     *
     */
    protected String skipDays;

    /**
     *
     */
    protected String skipHours;

    /**
     *
     */
    protected String textInput;

    /**
     *
     */
    protected String ttl;

    /**
     *
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
