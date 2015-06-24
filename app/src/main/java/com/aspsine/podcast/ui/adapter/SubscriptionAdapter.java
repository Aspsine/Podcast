package com.aspsine.podcast.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.PodCast;
import com.aspsine.podcast.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspsine on 2015/6/23.
 */
public class SubscriptionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PodCast> mPodCasts;

    public SubscriptionAdapter() {
        mPodCasts = new ArrayList<>();
    }

    public void setData(List<PodCast> podCasts) {
        mPodCasts.clear();
        mPodCasts.addAll(podCasts);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AlbumItemHolder(UIUtils.inflate(R.layout.item_album, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class AlbumItemHolder extends RecyclerView.ViewHolder {

        public AlbumItemHolder(View itemView) {
            super(itemView);
        }
    }
}
