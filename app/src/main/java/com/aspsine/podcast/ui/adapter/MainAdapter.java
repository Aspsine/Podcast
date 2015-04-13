package com.aspsine.podcast.ui.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.Album;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspsine on 2015/4/13.
 */
public class MainAdapter extends BaseAdapter{
    List<Album> albums;
    public MainAdapter(){
        this.albums = new ArrayList<Album>();
    }

    public void setAlbums(List<Album> albums){
        this.albums.clear();
        this.albums.addAll(albums);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public Object getItem(int position) {
        return albums.get(position);
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
            holder.lastUpdate = (TextView) convertView.findViewById(R.id.lastUpdate);
            holder.averageDuration = (TextView) convertView.findViewById(R.id.averageDuration);
            holder.description = (TextView) convertView.findViewById(R.id.description);
            holder.artwork = (SimpleDraweeView) convertView.findViewById(R.id.artwork);
            holder.href = (TextView) convertView.findViewById(R.id.href);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Album album = albums.get(position);
        holder.name.setText(album.getName());
        holder.href.setText(album.getHref());
        holder.lastUpdate.setText(album.getLastUpdate());

        holder.artwork.setImageURI(Uri.parse(album.getArtwork()));
        holder.averageDuration.setText(album.getAverageDuration());
        holder.description.setText(album.getDescription());
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
