package com.aspsine.podcast.ui.main.featured.item.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderFactory;

/**
 * Created by aspsine on 16/9/18.
 */


public class BannerViewHolderFactory implements ItemViewHolderFactory<BannerViewHolder> {

    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_featured_item_banner, parent, false);
        return new BannerViewHolder(itemView);
    }
}