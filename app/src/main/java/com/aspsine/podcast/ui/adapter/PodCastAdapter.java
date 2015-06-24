package com.aspsine.podcast.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
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
public class PodCastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<PodCast> mPodCasts;

    public PodCastAdapter(){
        mPodCasts = new ArrayList<>();
    }

    public void setData(List<PodCast> podCasts) {
        this.mPodCasts.clear();
        this.mPodCasts.addAll(podCasts);
        notifyDataSetChanged();
    }

    public void appendData(List<PodCast> podCasts){
        this.mPodCasts.addAll(podCasts);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PodCastViewHolder(UIUtils.inflate(R.layout.item_main, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindPodCastView((PodCastViewHolder) holder, position);
    }

    @Override
    public int getItemCount() {
        return mPodCasts.size();
    }

    private void bindPodCastView(PodCastViewHolder holder, int position) {
        PodCast podCast = mPodCasts.get(position);
        holder.name.setText(podCast.getName());
        holder.artwork.setImageURI(Uri.parse(podCast.getArtwork()));
    }

    public static class PodCastViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        SimpleDraweeView artwork;


        public PodCastViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            artwork = (SimpleDraweeView) itemView.findViewById(R.id.artwork);
        }
    }
}
