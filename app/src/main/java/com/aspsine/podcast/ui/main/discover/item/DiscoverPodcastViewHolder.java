package com.aspsine.podcast.ui.main.discover.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.bumptech.glide.Glide;

/**
 * Created by zhangfan10 on 16/10/8.
 */

public class DiscoverPodcastViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<DiscoverPodcastViewModel> {

    ImageView imageView;

    TextView tvName;

    TextView tvUpdateTime;

    TextView tvDescription;

    public DiscoverPodcastViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image_view);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvUpdateTime = (TextView) itemView.findViewById(R.id.tv_update_time);
        tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
    }

    @Override
    public void onBindViewHolder(int position, DiscoverPodcastViewModel viewModel) {
        tvName.setText(viewModel.getName());
        tvUpdateTime.setText(viewModel.getLastUpdate());
        tvDescription.setText(viewModel.getDescription());
        Glide.with(imageView.getContext()).load(viewModel.getArtwork()).centerCrop().into(imageView);
    }
}
