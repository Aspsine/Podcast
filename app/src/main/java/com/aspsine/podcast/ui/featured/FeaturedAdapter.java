package com.aspsine.podcast.ui.featured;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.featured.viewholder.FeaturedBannerViewHolder;
import com.aspsine.podcast.ui.featured.viewholder.FeaturedPodcastListViewHolder;
import com.aspsine.podcast.ui.featured.viewholder.FeaturedStationListViewHolder;
import com.aspsine.podcast.ui.featured.viewholder.FeaturedTitleViewHolder;
import com.aspsine.podcast.ui.featured.viewmodel.FeaturedItem;
import com.aspsine.podcast.ui.featured.viewmodel.FeaturedTitle;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedStationList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/11.
 */

public class FeaturedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FeaturedItem> mFeaturedItems;

    public FeaturedAdapter() {
        mFeaturedItems = new ArrayList<>();
    }

    public void setList(List<FeaturedItem> featuredItems){
        mFeaturedItems.clear();
        append(featuredItems);
    }

    public void append(List<FeaturedItem> featuredItems){
        mFeaturedItems.addAll(featuredItems);
        notifyDataSetChanged();
    }

    public void clear(){
        mFeaturedItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView;
        switch (viewType) {
            case FeaturedItem.TYPE_FEATURED_TITLE:
                itemView = inflater.inflate(R.layout.layout_featured_item_title, parent, false);
                return new FeaturedTitleViewHolder(itemView);
            case FeaturedItem.TYPE_FEATURED_STATION_LIST:
                itemView = inflater.inflate(R.layout.layout_featured_item_station_list, parent, false);
                return new FeaturedStationListViewHolder(itemView);
            case FeaturedItem.TYPE_FEATURED_PODCAST_LIST:
                itemView = inflater.inflate(R.layout.layout_featured_item_podcast_list, parent, false);
                return new FeaturedPodcastListViewHolder(itemView);
            case FeaturedItem.TYPE_FEATURED_BANNER:
                itemView = inflater.inflate(R.layout.layout_featured_item_banner, parent, false);
                return new FeaturedBannerViewHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        FeaturedItem featuredItem = mFeaturedItems.get(position);
        switch (type) {
            case FeaturedItem.TYPE_FEATURED_TITLE:
                FeaturedTitleViewHolder titleViewHolder = (FeaturedTitleViewHolder) holder;
                titleViewHolder.bind(featuredItem.getFeaturedTitle());
                break;
            case FeaturedItem.TYPE_FEATURED_STATION_LIST:
                FeaturedStationListViewHolder stationListViewHolder = (FeaturedStationListViewHolder) holder;
                stationListViewHolder.bind(featuredItem.getFeaturedStationList());
                break;
            case FeaturedItem.TYPE_FEATURED_PODCAST_LIST:
                FeaturedPodcastListViewHolder podcastListViewHolder = (FeaturedPodcastListViewHolder) holder;
                podcastListViewHolder.bind(featuredItem.getFeaturedPodcastList());
                break;

            case FeaturedItem.TYPE_FEATURED_BANNER:
                FeaturedBannerViewHolder bannerViewHolder = (FeaturedBannerViewHolder) holder;
                bannerViewHolder.bind(featuredItem.getFeaturedBanner());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mFeaturedItems.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mFeaturedItems.size();
    }

}
