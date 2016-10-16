package com.aspsine.podcast.widget.recyclerView;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;

/**
 * Created by aspsine on 16/10/15.
 */

public class LoadMoreHelper {

    private boolean isLoadingMore;

    private OnLoadMoreListener mOnLoadMoreListener;

    public void setOnLoadMoreListener(RecyclerView recyclerView, OnLoadMoreListener onLoadMoreListener){
        this.mOnLoadMoreListener = onLoadMoreListener;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (!ViewCompat.canScrollVertically(recyclerView, 1) && !isLoadingMore) {
                        isLoadingMore = true;
                        mOnLoadMoreListener.onLoadMore();
                    }
                }
            }
        });
    }

    public void startLoadMore(){
        mOnLoadMoreListener.onLoadMore();
    }

    public void stopLoadMore(){
        isLoadingMore = false;
    }

    public boolean isLoadingMore(){
        return isLoadingMore;
    }

    public interface OnLoadMoreListener {

        void onLoadMore();
    }
}
