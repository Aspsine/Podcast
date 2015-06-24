package com.aspsine.podcast.ui.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.PodCast;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspsine on 2015/4/13.
 */
public class MainAdapter extends BaseAdapter{
    List<PodCast> podCasts;
    public MainAdapter(){
        this.podCasts = new ArrayList<PodCast>();
    }

    public void setPodCasts(List<PodCast> podCasts){
        this.podCasts.clear();
        this.podCasts.addAll(podCasts);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return podCasts.size();
    }

    @Override
    public Object getItem(int position) {
        return podCasts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        PodCast podCast = podCasts.get(position);
        holder.name.setText(podCast.getName());
        holder.href.setText(podCast.getHref());
        holder.lastUpdate.setText(podCast.getLastUpdate());

        holder.artwork.setImageURI(Uri.parse(podCast.getArtwork()));
        holder.averageDuration.setText(podCast.getAverageDuration());
        holder.description.setText(podCast.getDescription());
        return convertView;
    }

    public static class ViewHolder{
        TextView name;
        TextView lastUpdate;
        TextView averageDuration;
        TextView description;
        SimpleDraweeView artwork;
        TextView href;
    }
}
