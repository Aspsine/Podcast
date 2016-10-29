package com.aspsine.podcast.ui.main.featured.item.tag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderFactory;

/**
 * Created by zhangfan10 on 16/9/18.
 */

public class TagListViewHolderFactory implements ItemViewHolderFactory<TagListViewHolder> {

    @Override
    public TagListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_featured_item_tag_list, parent, false);
        return new TagListViewHolder(itemView);
    }
}