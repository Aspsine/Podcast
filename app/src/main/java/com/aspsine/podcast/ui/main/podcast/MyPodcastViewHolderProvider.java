package com.aspsine.podcast.ui.main.podcast;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolderProvider;

/**
 * Created by zhangfan10 on 16/9/30.
 */

public class MyPodcastViewHolderProvider implements ItemViewHolderProvider<MyPodcastViewHolder>{

    @Override
    public MyPodcastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_podcast_item_my_podcast, parent, false);
        return new MyPodcastViewHolder(view);
    }
}
