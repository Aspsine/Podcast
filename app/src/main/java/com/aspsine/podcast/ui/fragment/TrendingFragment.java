package com.aspsine.podcast.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.widget.PagerTabItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingFragment extends BaseTabFragment {


    public TrendingFragment() {
        // Required empty public constructor
    }

    @Override
    public PagerTabItem.Type getType() {
        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }


}
