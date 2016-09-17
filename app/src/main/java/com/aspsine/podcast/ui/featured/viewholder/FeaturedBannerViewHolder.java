package com.aspsine.podcast.ui.featured.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.featured.viewmodel.FeaturedItem;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedBanner;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedPodcast;
import com.aspsine.podcast.widget.banner.BannerView;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by aspsine on 16/9/17.
 */

public class FeaturedBannerViewHolder extends RecyclerView.ViewHolder{

    private BannerView bannerView;

    public FeaturedBannerViewHolder(View itemView) {
        super(itemView);
        bannerView = (BannerView)itemView;
        bannerView.setItemLayoutId(R.layout.layout_featured_item_banner_item);
        bannerView.setOnItemClickListener(new BannerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {

            }
        });
    }

    public void bind(final FeaturedBanner featuredBanner){
        bannerView.setOnDataBindingCallback(new BannerView.OnDataBindingCallback() {
            @Override
            public void onDataBinding(int position, View view) {
                List<FeaturedItem> featuredItems = featuredBanner.getFeaturedItems();
                FeaturedItem featuredItem = featuredItems.get(position);
                FeaturedPodcast featuredPodcast = featuredItem.getFeaturedPodcast();
                Glide.with(bannerView.getContext()).load(featuredPodcast.getArtwork()).into((ImageView) view);
            }

            @Override
            public int getItemCount() {
                List<FeaturedItem> featuredItems = featuredBanner.getFeaturedItems();
                return featuredItems.size();
            }
        });
    }
}
