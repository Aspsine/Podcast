package com.aspsine.podcast.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.ui.widget.HorizonScrollItemView;

/**
 * Created by aspsine on 15-4-14.
 */
public class FeaturedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new HorizonScrollItemViewHolder(new HorizonScrollItemView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class HorizonScrollItemViewHolder extends RecyclerView.ViewHolder{

        public HorizonScrollItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
