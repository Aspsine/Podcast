package com.aspsine.podcast.ui.main.podcast;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.base.BaseFragment;
import com.aspsine.podcast.util.DisplayUtil;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPodcastsFragment extends BaseFragment implements MyPodcastsContract.View{

    public static final String TAG = MyPodcastsFragment.class.getSimpleName();

    private MyPodcastsContract.Presenter mPresenter;

    private RecyclerView recyclerView;

    private ItemViewAdapter<MyPodcastViewModel> mAdapter;

    public static Fragment newInstance() {
        return new MyPodcastsFragment();
    }

    public MyPodcastsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MyPodcastsPresenter(this);
        mAdapter = new ItemViewAdapter<>(new ArrayList<MyPodcastViewModel>(0));
    }

    @Override
    public void setPresenter(MyPodcastsContract.Presenter presenter) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_podcasts, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.main_tab_my_podcast));

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new MyPodcastsItemDecoration(DisplayUtil.dip2px(getContext(), 12)));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.start();
    }

    @Override
    public void bindData(List<MyPodcastViewModel> myPodcastViewModels) {
        mAdapter.setList(myPodcastViewModels);
    }
}
