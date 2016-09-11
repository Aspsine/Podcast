package com.aspsine.podcast.data.model;

import java.io.Serializable;

/**
 * Created by littlexi on 2015/4/12.
 */
public class Station implements Serializable{
    private String id;
    private String name;
    private String href;
    private int color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
