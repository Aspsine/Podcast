package com.aspsine.podcast.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.model.Station;

/**
 * Created by Aspsine on 2015/6/23.
 */
public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener<T> {
        void onItemClick(View v, int position, T t);
    }

    public interface OnItemMenuClickListener<T> {
        void onItemMenuClick(View v, int position, T t);
    }
}
