package com.aspsine.podcast.ui.main.featured.item.title;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderFactory;

/**
 * Created by aspsine on 16/9/18.
 */

public class TitleViewHolderFactory implements ItemViewHolderFactory<TitleViewHolder> {

    @Override
    public TitleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_featured_item_title, parent, false);
        return new TitleViewHolder(itemView);
    }
}
