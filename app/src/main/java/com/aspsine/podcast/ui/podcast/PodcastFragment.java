package com.aspsine.podcast.ui.podcast;


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
import com.aspsine.podcast.ui.podcast.item.EpisodeViewModel;
import com.aspsine.podcast.ui.podcast.mapper.EpisodeViewModelDataMapper;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PodcastFragment extends BaseFragment implements PodcastContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = PodcastFragment.class.getName();

    public static final String EXTRA_PODCAST_ID = "extra_podcast_id";

    private SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerView recyclerView;

    private ItemViewAdapter<EpisodeViewModel> mAdapter;

    private PodcastContract.Presenter mPresenter;

    public static PodcastFragment newInstance(String podcastId) {
        PodcastFragment podcastFragment = new PodcastFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_PODCAST_ID, podcastId);
        podcastFragment.setArguments(bundle);
        return podcastFragment;
    }

    public PodcastFragment() {
        // Required empty public constructor
    }

    @Override
    public void setPresenter(PodcastContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String podcastId = getArguments().getString(EXTRA_PODCAST_ID);
        final PodcastContract.Presenter presenter = new PodcastPresenter(this, podcastId);
        setPresenter(presenter);
        mAdapter = new ItemViewAdapter<>(new ArrayList<EpisodeViewModel>());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_podcast, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
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
        Toast.makeText(getActivity(), "Refresh error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void bindRefreshData(PodcastViewModel podcastViewModel) {
        mAdapter.setList(new EpisodeViewModelDataMapper().transform(podcastViewModel.getEpisodes()));
    }


}
