package com.aspsine.podcast.ui.podcast.item;

import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.util.UIUtils;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderProvider;

/**
 * Created by aspsine on 16/10/15.
 */

public class EpisodeViewHolderProvider implements ItemViewHolderProvider<EpisodeViewHolder> {

    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = UIUtils.inflate(R.layout.layout_podcast_episode_item, parent);
        return new EpisodeViewHolder(view);
    }
}
