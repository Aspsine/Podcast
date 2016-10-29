package com.aspsine.podcast.ui.podcast.item;

import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.util.UIUtils;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderFactory;

/**
 * Created by aspsine on 16/10/23.
 */

public class PodcastHeaderViewHolderFactory implements ItemViewHolderFactory<PodcastHeaderViewHolder> {
    @Override
    public PodcastHeaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = UIUtils.inflate(R.layout.layout_podcast_header_item, parent);
        return new PodcastHeaderViewHolder(view);
    }
}
