package com.aspsine.podcast.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.PodCast;
import com.aspsine.podcast.model.PodCastTrack;
import com.aspsine.podcast.util.UIUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspsine on 2015/6/30.
 */
public class TrackAdapter extends BaseRecyclerViewAdapter {

    private List<PodCastTrack> mTracks;

    public TrackAdapter() {
        mTracks = new ArrayList<>();
    }

    public void setData(List<PodCastTrack> tracks) {
        this.mTracks.clear();
        this.mTracks.addAll(tracks);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrackHolder(UIUtils.inflate(R.layout.item_podcast_track, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TrackHolder trackHolder = (TrackHolder) holder;
        PodCastTrack track = mTracks.get(position);
        trackHolder.tvTitle.setText((position + 1) + ". " + track.getTitle());
        trackHolder.tvDescription.setText(track.getDescription());
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public static final class TrackHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDescription;
        ImageView ivMenu;

        public TrackHolder(View itemView) {
            super(itemView);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            ivMenu = (ImageView) itemView.findViewById(R.id.ivMenu);
        }
    }
}
