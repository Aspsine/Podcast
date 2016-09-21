package com.aspsine.podcast.ui.featured;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.base.BaseFragment;
import com.aspsine.podcast.util.DisplayUtil;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment extends BaseFragment implements FeaturedContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = FeaturedFragment.class.getSimpleName();

    private FeaturedContract.Presenter mPresenter;

    private SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerView recyclerView;

    private ItemViewAdapter<ItemViewModel> mAdapter;

    public static Fragment newInstance() {
        return new FeaturedFragment();
    }

    public FeaturedFragment() {
        // Required empty public constructor
    }

    @Override
    public void setPresenter(@NonNull FeaturedContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FeaturedContract.Presenter presenter = new FeaturedPresenter(this);
        setPresenter(presenter);

        mAdapter = new FeaturedAdapter(new ArrayList<ItemViewModel>(0));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_featured, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new FeaturedItemDecoration(DisplayUtil.dip2px(getContext(), 12)));
        recyclerView.setAdapter(mAdapter);

        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.start();
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
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
    public void bindRefreshData(List<ItemViewModel> itemViewModels) {
        mAdapter.setList(itemViewModels);
    }

    @Override
    public void bindLoadMoreData(List<ItemViewModel> itemViewModels) {
        mAdapter.append(itemViewModels);
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
        stopLoadMore();
    }

    @Override
    public void startLoadMore() {
    }

    @Override
    public void stopLoadMore() {
    }

    @Override
    public void loadMoreError() {
    }
}
