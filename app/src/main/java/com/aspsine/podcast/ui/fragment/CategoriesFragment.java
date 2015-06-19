package com.aspsine.podcast.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.Section;
import com.aspsine.podcast.ui.adapter.CategoryAdapter;
import com.aspsine.podcast.ui.widget.PagerTabItem;
import com.aspsine.podcast.util.AssetUtils;
import com.aspsine.podcast.util.L;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends BaseTabFragment implements CategoryAdapter.OnItemClickListener{


    private static final String TAG = CategoriesFragment.class.getSimpleName();
    private CategoryAdapter mAdapter;
    private int mCurrentSelectedPosition = 0;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public PagerTabItem.Type getType() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new CategoryAdapter();
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
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
