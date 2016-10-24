package com.aspsine.podcast.widget.recyclerView.item;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/17.
 */

public class ItemViewAdapter<ViewModel extends ItemViewModel> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ViewModel> mItemViewModels;

    public ItemViewAdapter() {
        this.mItemViewModels = new ArrayList<>();
    }

    public void setList(List<ViewModel> itemViewModels) {
        if (itemViewModels != null) {
            mItemViewModels.clear();
            append(itemViewModels);
        }
    }

    public void append(List<ViewModel> itemViewModels) {
        if (mItemViewModels != null && itemViewModels != null) {
            int count = mItemViewModels.size();
            mItemViewModels.addAll(itemViewModels);
            if (count > 0) {
                notifyItemRangeInserted(count, mItemViewModels.size());
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public List<ViewModel> getList(){
        return mItemViewModels;
    }

    public void clear() {
        if (mItemViewModels != null) {
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

    public Class<? extends ItemViewModel> getItemViewModelClass(int type) {
        return ItemViewHolderProviderPool.getItemViewModelClass(type);
    }
}
