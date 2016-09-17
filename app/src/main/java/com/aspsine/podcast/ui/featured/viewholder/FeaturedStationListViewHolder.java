package com.aspsine.podcast.ui.featured.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.featured.ItemMarginDecoration;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedStation;
import com.aspsine.podcast.ui.featured.viewmodel.type.FeaturedStationList;
import com.aspsine.podcast.util.DisplayUtil;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by aspsine on 16/9/13.
 */

public class FeaturedStationListViewHolder extends RecyclerView.ViewHolder {

    private RecyclerView recyclerView;

    public FeaturedStationListViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView;
        recyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(), 1, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new ItemMarginDecoration(DisplayUtil.dip2px(itemView.getContext(), 12)));
    }

    public void bind(FeaturedStationList featuredStationList) {
        FeaturedStationsAdapter adapter = (FeaturedStationsAdapter) recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new FeaturedStationsAdapter();
            recyclerView.setAdapter(adapter);
        }
        adapter.setList(featuredStationList.getFeaturedStations());
    }

    private static class FeaturedStationsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<FeaturedStation> mFeaturedStations;

        FeaturedStationsAdapter() {
            this.mFeaturedStations = new ArrayList<>();
        }

        public void setList(List<FeaturedStation> featuredStations) {
            this.mFeaturedStations.clear();
            this.mFeaturedStations.addAll(featuredStations);
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_featured_item_station_list_item_station, parent, false);
            return new StationViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            FeaturedStation featuredStation = mFeaturedStations.get(position);
            StationViewHolder stationViewHolder = (StationViewHolder) holder;
            stationViewHolder.bind(featuredStation);
        }

        @Override
        public int getItemCount() {
            return mFeaturedStations.size();
        }
    }

    private static class StationViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        StationViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView;

            Context context = itemView.getContext();
            int minScreenSize = Math.min(DisplayUtil.getScreenWidth(context), DisplayUtil.getScreenHeight(context));
            int space = DisplayUtil.dip2px(context, 12);
            float num = 3.5f;
            int width = (int) (((minScreenSize - space * num) / num * 3 + 2 * space - space) / 2);

            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(width, width / 2);
            itemView.setLayoutParams(layoutParams);
        }

        void bind(FeaturedStation featuredStation) {
            Context context = imageView.getContext();
            Glide.with(context)
                    .load(featuredStation.getImage())
                    .centerCrop()
                    .bitmapTransform(new RoundedCornersTransformation(context, DisplayUtil.dip2px(context, 12), 0))
                    .into(imageView);
        }
    }
}
