package com.aspsine.podcast.ui.featured.item.banner;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.featured.item.podcast.PodcastListViewModel;
import com.aspsine.podcast.ui.featured.item.podcast.PodcastViewModel;
import com.aspsine.podcast.ui.featured.viewmodel.FeaturedItem;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedPodcast;
import com.aspsine.podcast.widget.banner.BannerView;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

public class BannerViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<BannerViewModel> {
    private BannerView bannerView;

    public BannerViewHolder(View itemView) {
        super(itemView);
        bannerView = (BannerView) itemView;
        bannerView.setItemLayoutId(R.layout.layout_featured_item_banner_item);
        bannerView.setOnItemClickListener(new BannerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {

            }
        });
    }

    @Override
    public void onBindViewHolder(int position, final BannerViewModel bannerViewModel) {
        bannerView.setOnDataBindingCallback(new BannerView.OnDataBindingCallback() {
            @Override
            public void onDataBinding(int position, View view) {
                List<ItemViewModel> itemViewModels = bannerViewModel.getItemViewModels();
                ItemViewModel itemViewModel = itemViewModels.get(position);
                if (itemViewModel instanceof PodcastViewModel) {
                    PodcastViewModel podcastViewModel = (PodcastViewModel) itemViewModel;
                    Glide.with(bannerView.getContext()).load(podcastViewModel.getArtwork()).centerCrop().into((ImageView) view);
                }
            }

            @Override
            public int getItemCount() {
                List<ItemViewModel> itemViewModels = bannerViewModel.getItemViewModels();
                return itemViewModels.size();
            }
        });
    }
}
