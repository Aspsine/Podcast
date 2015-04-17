package com.aspsine.podcast.ui.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 15-4-13.
 */
public class NavigationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Station> mStations;

    private OnItemClickListener mListener;

    public NavigationAdapter() {
        mStations = new ArrayList<Station>();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public void setStations(List<Station> mStations) {
        this.mStations.clear();
        this.mStations.addAll(mStations);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new NavigationHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_navigation, viewGroup, false), mListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        NavigationHolder holder = (NavigationHolder) viewHolder;
        holder.bindData(mStations.get(position), mCurrentCheckedPosition == position);
    }

    @Override
    public int getItemCount() {
        return mStations.size();
    }

    private int mLastCheckedPosition = -1;
    private int mCurrentCheckedPosition = 0;

    public void setItemChecked(int position, boolean b) {
        mLastCheckedPosition = mCurrentCheckedPosition;
        mCurrentCheckedPosition = position;
        if (mLastCheckedPosition != -1) {
            notifyItemChanged(mLastCheckedPosition);
        }
        notifyItemChanged(position);
    }

    public static class NavigationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text;

        OnItemClickListener mmListener;

        public NavigationHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            mmListener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindData(Station station, boolean isSelected) {
            text.setText(station.getName());
            if(isSelected){
                itemView.setBackgroundColor(Color.GRAY);
            }else {
                itemView.setBackgroundColor(Color.WHITE);
            }
        }

        @Override
        public void onClick(View v) {
            if (mmListener != null) {
                mmListener.onItemClick(v, getPosition());
            }
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View v, int position);
    }

    public Station getItem(int position){
        return mStations.get(position);
    }
}
