package com.aspsine.podcast.ui.fragment;


import android.app.Fragment;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.Section;
import com.aspsine.podcast.model.Station;
import com.aspsine.podcast.ui.adapter.StationsAdapter;
import com.aspsine.podcast.util.AssetUtils;
import com.aspsine.podcast.util.L;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 */
public class StationsFragment extends BaseTabFragment implements StationsAdapter.OnItemClickListener{
    private static final String TAG = StationsFragment.class.getSimpleName();
    private StationsAdapter mAdapter;
    private int mCurrentSelectedPosition = 0;


    public StationsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new StationsAdapter();
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stations, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String json = AssetUtils.getStringFromAsset(getActivity(), "filter.json");
        L.i(TAG, json);
        Gson gson = new Gson();
        Section section = gson.fromJson(json, Section.class);
        mAdapter.setSection(section);
    }


    @Override
    public void onItemClick(View v, int position) {
        selectItem(position);
    }

    private void selectItem(int position) {
    }

}
