package com.aspsine.podcast.ui.adapter;

import android.support.v7.widget.RecyclerView;
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
    private List<Station> stations;

    public NavigationAdapter(){
        stations = new ArrayList<Station>();
    }

    public void setStations(List<Station> stations){
        this.stations.clear();
        this.stations.addAll(stations);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new NavigationHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_navigation, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        NavigationHolder holder = (NavigationHolder) viewHolder;
        holder.text.setText(stations.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    public static class NavigationHolder extends RecyclerView.ViewHolder{
        TextView text;
        public NavigationHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
