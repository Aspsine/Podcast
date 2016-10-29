package com.aspsine.rss.model;

/**
 * Created by aspsine on 15/6/27.
 * http://www.w3cschool.cc/rss/rss-item.html
 * http://www.rssboard.org/rss-specification
 */
public class Item {
    /**
     * must
     * <p>
     * The title of the item.
     */
    protected String title;
    /**
     * must
     * <p>
     * The item synopsis.
     */
    protected String description;
    /**
     * must
     * <p>
     * The URL of the item.
     */
    protected String link;
    /**
     * Email address of the author of the item. More.
     */
    protected String author;
    /**
     * Includes the item in one or more categories. More.
     */
    protected String category;
    /**
     * URL of a page for comments relating to the item. More.
     */
    protected String comments;
    /**
     * Describes a media object that is attached to the item. More.
     */
    protected Enclosure enclosure;
    /**
     * A string that uniquely identifies the item. More.
     */
    protected String guid;
    /**
     * Indicates when the item was published. More.
     */
    protected String pubDate;
    /**
     * The RSS channel that the item came from. More.
     */
    protected String source;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
