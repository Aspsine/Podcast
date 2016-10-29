package com.aspsine.podcast.ui.main.featured;

import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.aspsine.podcast.ui.main.featured.item.podcast.PodcastListViewModel;
import com.aspsine.podcast.ui.main.featured.item.station.StationListViewModel;
import com.aspsine.podcast.ui.main.featured.item.tag.TagListViewModel;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/20.
 */

class FeaturedAdapter extends ItemViewAdapter<ItemViewModel> {

    private SparseArray<Parcelable> mSavedStates = new SparseArray<>();

    public void clearSavedStates(){
        this.mSavedStates.clear();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final RecyclerView.ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);

        Class<?> clazz = getItemViewModelClass(viewType);

        RecyclerView recyclerView = null;

        if (clazz == PodcastListViewModel.class) {
            recyclerView = (RecyclerView) viewHolder.itemView;
        } else if (clazz == StationListViewModel.class) {
            recyclerView = (RecyclerView) viewHolder.itemView;
        } else if (clazz == TagListViewModel.class) {
            recyclerView = (RecyclerView) viewHolder.itemView;
        }

        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        int position = viewHolder.getAdapterPosition();
                        mSavedStates.put(position, recyclerView.getLayoutManager().onSaveInstanceState());
                    }
                }
            });
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);

        Class<?> clazz = getItemViewModelClass(viewType);

        RecyclerView recyclerView = null;

        if (clazz == PodcastListViewModel.class) {
            recyclerView = (RecyclerView) holder.itemView;
        } else if (clazz == StationListViewModel.class) {
            recyclerView = (RecyclerView) holder.itemView;
        } else if (clazz == TagListViewModel.class) {
            recyclerView = (RecyclerView) holder.itemView;
        }

        if (recyclerView != null) {
            final Parcelable parcelable = mSavedStates.get(position);
            if (parcelable != null) {
                final RecyclerView finalRecyclerView = recyclerView;
                recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        finalRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                        finalRecyclerView.getLayoutManager().onRestoreInstanceState(parcelable);
                        return true;
                    }
                });
            } else {
                recyclerView.scrollToPosition(0);
                super.onBindViewHolder(holder, position);
            }
        } else {
            super.onBindViewHolder(holder, position);
        }
    }
}
