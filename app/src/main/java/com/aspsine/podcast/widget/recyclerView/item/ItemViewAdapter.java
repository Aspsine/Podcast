package com.aspsine.podcast.widget.recyclerView.item;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aspsine on 16/9/17.
 */

public class ItemViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemViewModel> mItemViewModels;

    public ItemViewAdapter(List<? extends ItemViewModel> itemViewModels) {
        this.mItemViewModels = (List<ItemViewModel>) itemViewModels;
    }

    public void setList(List<? extends ItemViewModel> itemViewModels) {
        if (itemViewModels != null) {
            mItemViewModels = (List<ItemViewModel>) itemViewModels;
            notifyDataSetChanged();
        }
    }

    public void append(List<ItemViewModel> itemViewModels) {
        if (mItemViewModels != null && itemViewModels != null){
            mItemViewModels.addAll(itemViewModels);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (mItemViewModels != null){
            mItemViewModels.clear();
            notifyDataSetChanged();
        }
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
