package com.aspsine.podcast.ui.main.discover.item;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.podcast.PodcastActivity;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.bumptech.glide.Glide;

/**
 * Created by zhangfan10 on 16/10/8.
 */

public class DiscoverPodcastViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<DiscoverPodcastViewModel> {

    ImageView ivCover;

    TextView tvName;

    TextView tvUpdateTime;

    TextView tvDescription;

    public DiscoverPodcastViewHolder(View itemView) {
        super(itemView);
        ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvUpdateTime = (TextView) itemView.findViewById(R.id.tv_update_time);
        tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
    }

    @Override
    public void onBindViewHolder(int position, final DiscoverPodcastViewModel viewModel) {
        tvName.setText(viewModel.getName());
        tvUpdateTime.setText(viewModel.getLastUpdate());
        tvDescription.setText(viewModel.getDescription());
        Glide.with(ivCover.getContext()).load(viewModel.getArtwork()).centerCrop().into(ivCover);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PodcastActivity.intentInto(v.getContext(), viewModel.getId());
            }
        });
    }
}
