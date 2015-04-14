package com.aspsine.podcast.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PodcastsFragment extends BaseTabFragment {


    public PodcastsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_podcasts, container, false);
    }


}
