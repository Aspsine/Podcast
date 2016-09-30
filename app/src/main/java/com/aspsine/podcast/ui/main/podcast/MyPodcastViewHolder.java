package com.aspsine.podcast.ui.main.podcast;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.bumptech.glide.Glide;

/**
 * Created by zhangfan10 on 16/9/30.
 */

public class MyPodcastViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<MyPodcastViewModel> {

    public ImageView ivCover;

    public TextView tvName;

    public TextView tvUpdateTime;

    public TextView tvNumber;

    public MyPodcastViewHolder(View itemView) {
        super(itemView);

        ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);

        tvName = (TextView) itemView.findViewById(R.id.tv_name);

        tvUpdateTime = (TextView) itemView.findViewById(R.id.tv_update_time);

        tvNumber = (TextView) itemView.findViewById(R.id.tv_number);
    }

    @Override
    public void onBindViewHolder(int position, MyPodcastViewModel myPodcastViewModel) {
        Glide.with(ivCover.getContext()).load(myPodcastViewModel.getArtwork()).centerCrop().into(ivCover);
        tvName.setText(myPodcastViewModel.getName());
        tvUpdateTime.setText(myPodcastViewModel.getLastUpdateTime());
        tvNumber.setText(String.valueOf(position));
    }


}
