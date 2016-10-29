package com.aspsine.podcast.widget.recyclerView.item;

import android.view.ViewGroup;

/**
 * Created by aspsine on 16/9/17.
 */

public interface ItemViewHolderFactory<ViewHolder extends ItemViewHolder> {

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

}
