package com.aspsine.podcast.ui.featured.item.tag;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

/**
 * Created by zhangfan10 on 16/9/18.
 */

public class TagViewModel implements ItemViewModel{
    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
