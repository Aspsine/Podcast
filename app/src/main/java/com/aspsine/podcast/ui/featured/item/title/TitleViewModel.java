package com.aspsine.podcast.ui.featured.item.title;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

/**
 * Created by zhangfan10 on 16/9/13.
 */

public class TitleViewModel implements ItemViewModel{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
