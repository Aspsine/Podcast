package com.aspsine.podcast.ui.main.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.base.BaseFragment;

/**
 * Created by zhangfan10 on 16/9/30.
 */

public class DiscoverFragment extends BaseFragment{

    public static Fragment newInstance() {
        DiscoverFragment fragment =  new DiscoverFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discover, container, false);
    }

}
