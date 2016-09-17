package com.aspsine.podcast.ui.featured.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.featured.ItemMarginDecoration;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedPodcast;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedPodcastList;
import com.aspsine.podcast.util.DisplayUtil;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/13.
 */

public class FeaturedPodcastListViewHolder extends RecyclerView.ViewHolder {

    public RecyclerView recyclerView;

    public FeaturedPodcastListViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(itemView.getContext(), 2,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new ItemMarginDecoration(DisplayUtil.dip2px(itemView.getContext(), 12)));
    }

    public void bind(FeaturedPodcastList featuredPodcastList) {
        FeaturedPodcastAdapter adapter = (FeaturedPodcastAdapter) recyclerView.getAdapter();
        if (adapter == null){
            adapter = new FeaturedPodcastAdapter();
            recyclerView.setAdapter(adapter);
        }
        List<FeaturedPodcast> featuredPodcasts = featuredPodcastList.getFeaturedPodcasts();
        adapter.setList(featuredPodcasts);
    }

    private static class FeaturedPodcastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<FeaturedPodcast> mFeaturedPodcasts;

        FeaturedPodcastAdapter() {
            mFeaturedPodcasts = new ArrayList<>();
        }

        void setList(List<FeaturedPodcast> featuredPodcasts) {
            mFeaturedPodcasts.clear();
            mFeaturedPodcasts.addAll(featuredPodcasts);
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.layout_featured_item_podcast_list_item_podcast, parent, false);
            return new PodcastViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            PodcastViewHolder podcastViewHolder = (PodcastViewHolder)holder;
            podcastViewHolder.bind(mFeaturedPodcasts.get(position));
        }

        @Override
        public int getItemCount() {
            return mFeaturedPodcasts.size();
        }
    }

    private static class PodcastViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivCover;
        private TextView tvPodcastName;
        private TextView tvStationName;

        PodcastViewHolder(View itemView) {
            super(itemView);

            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvPodcastName = (TextView) itemView.findViewById(R.id.tv_podcast_name);
            tvStationName = (TextView) itemView.findViewById(R.id.tv_station_name);

            Context context = itemView.getContext();

            int minScreenSize = Math.min(DisplayUtil.getScreenWidth(context), DisplayUtil.getScreenHeight(context));
            int space = DisplayUtil.dip2px(context, 12);
            float num = 3.5f;
            int width = (int) ((minScreenSize - space * num) / num);

            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(width, RecyclerView.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(layoutParams);
        }

        void bind(FeaturedPodcast podcast) {
            Glide.with(ivCover.getContext()).load(podcast.getArtwork()).centerCrop().into(ivCover);
            tvPodcastName.setText(podcast.getName());
            tvStationName.setText(podcast.getStation());
        }
    }

}
