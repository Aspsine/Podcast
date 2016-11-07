package com.aspsine.podcast.ui.main.featured.item.podcast;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.podcast.PodcastActivity;
import com.aspsine.podcast.util.DisplayUtil;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.bumptech.glide.Glide;

/**
 * Created by aspsine on 16/9/18.
 */

public class PodcastViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<PodcastViewModel>{
    private ImageView ivCover;
    private TextView tvPodcastName;
    private TextView tvStationName;

    public PodcastViewHolder(View itemView) {
        super(itemView);
        ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
        tvPodcastName = (TextView) itemView.findViewById(R.id.tv_podcast_name);
        tvStationName = (TextView) itemView.findViewById(R.id.tv_station_name);

        Context context = itemView.getContext();

        int minScreenSize = Math.min(DisplayUtil.getScreenWidth(context), DisplayUtil.getScreenHeight(context));
        int space = DisplayUtil.dip2px(context, 12);
        float num = 3.25f;
        int spaceNum = (int) Math.ceil(num);
        int width = (int) ((minScreenSize - space * spaceNum) / num);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(width, RecyclerView.LayoutParams.WRAP_CONTENT);
        itemView.setLayoutParams(layoutParams);
    }

    @Override
    public void onBindViewHolder(int position, final PodcastViewModel podcastViewModel) {
        Glide.with(ivCover.getContext()).load(podcastViewModel.getArtwork()).centerCrop().into(ivCover);
        tvPodcastName.setText(podcastViewModel.getName());
        tvStationName.setText(podcastViewModel.getStation());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PodcastActivity.intentInto(view.getContext(), podcastViewModel.getId());
            }
        });
    }
}
