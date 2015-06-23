package com.aspsine.podcast.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.adapter.SubscriptionAdapter;
import com.aspsine.podcast.ui.widget.PagerTabItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubscriptionsFragment extends BaseTabFragment {
    private SubscriptionAdapter mAdapter;
    private ProgressBar progressBar;

    public SubscriptionsFragment() {
        // Required empty public constructor
    }

    @Override
    public PagerTabItem.Type getType() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new SubscriptionAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subscriptions, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new SubscriptionAdapter());
    }

    
}
