package com.aspsine.podcast.widget.recyclerView.item;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aspsine on 16/9/17.
 */

public class ItemViewAdaper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemViewModel> mItemViewModels;

    public ItemViewAdaper(List<ItemViewModel> itemViewModels) {
        this.mItemViewModels = itemViewModels;
    }

    @Override
    public int getItemCount() {
        return mItemViewModels == null ? 0 : mItemViewModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return ItemViewHolderProviderPool.getItemViewType(mItemViewModels.get(position).getClass());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return (RecyclerView.ViewHolder) ItemViewHolderProviderPool.get(viewType).onCreateViewHolder(parent, viewType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.onBindViewHolder(position, mItemViewModels.get(position));
    }
}
