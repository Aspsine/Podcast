package com.aspsine.podcast.ui.search.item;

import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.util.UIUtils;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderFactory;

/**
 * Created by aspsine on 16/10/30.
 */

public class SearchPodcastViewHolderFactory implements ItemViewHolderFactory<SearchPodcastViewHolder> {

    @Override
    public SearchPodcastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = UIUtils.inflate(R.layout.layout_search_item_podcast, parent);
        return new SearchPodcastViewHolder(view);
    }
}
