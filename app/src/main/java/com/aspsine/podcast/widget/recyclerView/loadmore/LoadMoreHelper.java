package com.aspsine.podcast.widget.recyclerView.loadmore;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by aspsine on 16/10/15.
 */

public class LoadMoreHelper {

    public static LoadMoreAble help(RecyclerView recyclerView) {

        return new LoadMoreAble(recyclerView);
    }

    public static class LoadMoreAble {

        private boolean isLoadingMore;

        private RecyclerView recyclerView;

        private OnLoadMoreListener mOnLoadMoreListener;

        public LoadMoreAble(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
            recyclerView.addOnScrollListener(onScrollListener);
        }

        public LoadMoreAble setOnLoadMoreListener(OnLoadMoreListener listener) {
            this.mOnLoadMoreListener = listener;
            return this;
        }

        public void removeOnLoadMoreListener() {
            recyclerView.removeOnScrollListener(onScrollListener);
            mOnLoadMoreListener = null;
        }

        private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (canTriggerLoadMore() && mOnLoadMoreListener != null) {
                    isLoadingMore = true;
                    mOnLoadMoreListener.onLoadMore();
                }
            }
        };

        protected boolean canTriggerLoadMore() {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int lastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
            return lastVisiblePosition + 10 > recyclerView.getAdapter().getItemCount()
                    && !isLoadingMore;
        }

        public void stopLoadMore() {
            isLoadingMore = false;
        }

        public boolean isLoadingMore() {
            return isLoadingMore;
        }
    }
}
