package com.aspsine.podcast.ui.featured;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.irecyclerview.IViewHolder;
import com.aspsine.podcast.data.rss.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/11.
 */

public class FeaturedAdapter extends RecyclerView.Adapter<IViewHolder> {

    private List<ItemData> mItemDatas;

    public FeaturedAdapter (){
        this.mItemDatas = new ArrayList<>();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ItemViewHolder extends IViewHolder{

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ItemData{

    }
}
