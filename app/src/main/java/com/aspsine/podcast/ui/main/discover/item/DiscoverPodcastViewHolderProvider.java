package com.aspsine.podcast.ui.main.discover.item;

import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.util.UIUtils;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderProvider;

/**
 * Created by zhangfan10 on 16/10/8.
 */

public class DiscoverPodcastViewHolderProvider implements ItemViewHolderProvider<DiscoverPodcastViewHolder> {

    @Override
    public DiscoverPodcastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View itemView = UIUtils.inflate(R.layout.layout_discover_item_podcast, parent);
        return new DiscoverPodcastViewHolder(itemView);
    }
}
