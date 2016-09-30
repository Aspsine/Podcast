package com.aspsine.podcast.ui.main.featured.item.station;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.aspsine.podcast.util.DisplayUtil;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by aspsine on 16/9/18.
 */

public class StationViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<StationViewModel> {

    public ImageView imageView;

    public StationViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView;

        Context context = itemView.getContext();
        int minScreenSize = Math.min(DisplayUtil.getScreenWidth(context), DisplayUtil.getScreenHeight(context));
        int space = DisplayUtil.dip2px(context, 12);
        float podcastShowNum = 2.5f;
        int podcastNum = 4;
        int stationNum = 3;
        int width = (int) ((minScreenSize - space * podcastShowNum) / podcastShowNum);
        width = (width * podcastNum + space * (podcastNum - 1) - space * (stationNum - 1)) / stationNum;

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(width, width / 2);
        itemView.setLayoutParams(layoutParams);
    }

    @Override
    public void onBindViewHolder(int position, StationViewModel stationViewModel) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(stationViewModel.getImage())
                .bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, DisplayUtil.dip2px(context, 8), 0))
                .into(imageView);
    }
}
