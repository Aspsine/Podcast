package com.aspsine.podcast.widget.recyclerView.item;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aspsine on 16/9/17.
 */

public class ItemViewAdapter<ViewModel extends ItemViewModel> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ViewModel> mItemViewModels;

    public ItemViewAdapter(List<ViewModel> itemViewModels) {
        this.mItemViewModels = itemViewModels;
    }

    public void setList(List<ViewModel> itemViewModels) {
        if (itemViewModels != null) {
            mItemViewModels = itemViewModels;
            notifyDataSetChanged();
        }
    }

    public void append(List<ViewModel> itemViewModels) {
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
