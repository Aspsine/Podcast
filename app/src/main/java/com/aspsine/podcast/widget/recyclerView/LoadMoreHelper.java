package com.aspsine.podcast.widget.recyclerView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by aspsine on 16/10/15.
 */

public class LoadMoreHelper {

    private boolean isLoadingMore;

    private OnLoadMoreListener mOnLoadMoreListener;

    public void setOnLoadMoreListener(RecyclerView recyclerView, OnLoadMoreListener onLoadMoreListener) {
        this.mOnLoadMoreListener = onLoadMoreListener;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.findLastVisibleItemPosition() + 10 > recyclerView.getAdapter().getItemCount()
                        && !isLoadingMore) {
                    isLoadingMore = true;
                    mOnLoadMoreListener.onLoadMore();
                }
            }
        });
    }

    public void startLoadMore() {
        mOnLoadMoreListener.onLoadMore();
    }

    public void stopLoadMore() {
        isLoadingMore = false;
    }

    public void loadMoreError() {
        isLoadingMore = false;
    }

    public void loadMoreEnd() {
        isLoadingMore = false;
    }

    public boolean isLoadingMore() {
        return isLoadingMore;
    }

    public interface OnLoadMoreListener {

        void onLoadMore();
    }
}
