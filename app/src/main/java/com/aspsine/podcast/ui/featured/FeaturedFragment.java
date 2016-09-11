package com.aspsine.podcast.ui.featured;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.base.BaseFragment;
import com.aspsine.podcast.widget.refresh.LoadMoreFooterView;

import static com.facebook.common.internal.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment extends BaseFragment implements FeaturedContract.View,
        OnRefreshListener, OnLoadMoreListener {

    public static final String TAG = FeaturedFragment.class.getSimpleName();

    private FeaturedContract.Presenter mPresenter;

    private Toolbar toolbar;

    private IRecyclerView iRecyclerView;

    private LoadMoreFooterView loadMoreFooterView;

    private FeaturedAdapter mAdapter;

    public static Fragment newInstance() {
        return new FeaturedFragment();
    }

    public FeaturedFragment() {
        // Required empty public constructor
    }

    @Override
    public void setPresenter(@NonNull FeaturedContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FeaturedContract.Presenter presenter = new FeaturedPresenter(this);
        setPresenter(presenter);

        mAdapter = new FeaturedAdapter();
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
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.main_tab_featured));

        iRecyclerView = (IRecyclerView) view.findViewById(R.id.iRecyclerView);
        iRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadMoreFooterView = (LoadMoreFooterView) iRecyclerView.getLoadMoreFooterView();
        iRecyclerView.setIAdapter(mAdapter);

        iRecyclerView.setOnRefreshListener(this);
        iRecyclerView.setOnLoadMoreListener(this);
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
    public void onLoadMore() {
        mPresenter.loadMore();
    }

    @Override
    public void startRefresh() {
        iRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                iRecyclerView.setRefreshing(true);
            }
        });
    }

    @Override
    public void stopRefresh() {
        iRecyclerView.setRefreshing(false);
    }

    @Override
    public void refreshError() {
        stopLoadMore();
    }

    @Override
    public void showLoadMore() {
        loadMoreFooterView.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoadMore() {
        loadMoreFooterView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loadMoreError() {
        loadMoreFooterView.setVisibility(View.INVISIBLE);
    }
}
