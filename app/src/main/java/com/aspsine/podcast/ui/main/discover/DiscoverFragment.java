package com.aspsine.podcast.ui.main.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.base.BaseFragment;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;
import com.aspsine.podcast.widget.recyclerView.loadmore.ItemViewLoadMoreAdapter;
import com.aspsine.podcast.widget.recyclerView.loadmore.LoadMoreHelper;
import com.aspsine.podcast.widget.recyclerView.loadmore.OnLoadMoreListener;
import com.aspsine.podcast.widget.recyclerView.loadmore.State;

import java.util.List;

/**
 * Created by zhangfan10 on 16/9/30.
 */

public class DiscoverFragment extends BaseFragment implements DiscoverContract.View
        , SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {

    private SwipeRefreshLayout swipeRefreshLayout;

    private DiscoverContract.Presenter mPresenter;

    private LoadMoreHelper.LoadMoreAble mLoadMoreAble;

    private ItemViewLoadMoreAdapter<ItemViewModel> mAdapter;

    public static Fragment newInstance() {
        return new DiscoverFragment();
    }

    @Override
    public void setPresenter(DiscoverContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DiscoverContract.Presenter presenter = new DiscoverPresenter(this);
        setPresenter(presenter);
        mAdapter = new ItemViewLoadMoreAdapter<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discover, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        mLoadMoreAble = LoadMoreHelper.help(recyclerView).setOnLoadMoreListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.start();
    }

    @Override
    public void startRefresh() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    @Override
    public void stopRefresh() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void refreshError() {
        stopRefresh();
        Toast.makeText(getActivity(), "refresh error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMore() {
        mAdapter.setState(State.LoadingMore);
        mPresenter.loadMore();
    }

    @Override
    public void stopLoadMore() {
        mLoadMoreAble.stopLoadMore();
        mAdapter.setState(State.Empty);
    }

    @Override
    public void loadMoreEnd() {
        mAdapter.setState(State.End);
    }

    @Override
    public void loadMoreError() {
        stopLoadMore();
        mAdapter.setState(State.Error);
    }

    @Override
    public void bindRefreshData(List<ItemViewModel> itemViewModels) {
        mAdapter.setList(itemViewModels);
    }

    @Override
    public void bindLoadMoreData(List<ItemViewModel> itemViewModels) {
        mAdapter.append(itemViewModels);
    }

}
