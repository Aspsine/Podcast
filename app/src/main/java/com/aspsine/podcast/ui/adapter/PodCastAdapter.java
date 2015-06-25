package com.aspsine.podcast.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.PodCast;
import com.aspsine.podcast.util.UIUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspsine on 2015/6/24.
 */
public class PodCastAdapter extends BaseRecyclerViewAdapter {
    private List<PodCast> mPodCasts;

    private OnItemClickListener mOnItemClickListener;
    private OnItemMenuClickListener mOnItemMenuClickListener;

    public PodCastAdapter() {
        mPodCasts = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public void setOnItemMenuClickListener(OnItemMenuClickListener listener) {
        this.mOnItemMenuClickListener = listener;
    }

    public void setData(List<PodCast> podCasts) {
        this.mPodCasts.clear();
        this.mPodCasts.addAll(podCasts);
        notifyDataSetChanged();
    }

    public void appendData(List<PodCast> podCasts) {
        this.mPodCasts.addAll(podCasts);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final PodCastViewHolder holder = new PodCastViewHolder(UIUtils.inflate(R.layout.item_podcast, parent));
        holder.ibMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemMenuClickListener.onItemMenuClick(v, holder.getLayoutPosition(), mPodCasts.get(holder.getLayoutPosition()));
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, holder.getLayoutPosition(), mPodCasts.get(holder.getLayoutPosition()));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindPodCastView((PodCastViewHolder) holder, position);
    }

    @Override
    public int getItemCount() {
        return mPodCasts.size();
    }

    private void bindPodCastView(final PodCastViewHolder holder, int position) {
        final PodCast podCast = mPodCasts.get(position);
        holder.tvName.setText(position + ". " + podCast.getName());
        holder.tvStation.setText(podCast.getStation());
        holder.sdvArtwork.setImageURI(Uri.parse(podCast.getArtwork()));
    }

    public static class PodCastViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvStation;
        SimpleDraweeView sdvArtwork;
        ImageButton ibMenu;

        public PodCastViewHolder(View itemView) {
            super(itemView);
            tvStation = (TextView) itemView.findViewById(R.id.tvStation);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            sdvArtwork = (SimpleDraweeView) itemView.findViewById(R.id.sdvArtwork);
            ibMenu = (ImageButton) itemView.findViewById(R.id.ibMenu);
        }
    }
}
