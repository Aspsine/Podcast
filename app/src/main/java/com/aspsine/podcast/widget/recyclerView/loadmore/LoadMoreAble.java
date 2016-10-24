package com.aspsine.podcast.widget.recyclerView.loadmore;

/**
 * Created by aspsine on 16/10/22.
 */

public interface LoadMoreAble {

    public void startLoadMore();

    public void stopLoadMore();

    public void loadMoreError();

    public void loadMoreEnd();

    boolean isLoadingMore();

    boolean canLoadMore();
}
