package com.aspsine.podcast.ui.featured.item.tag;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.podcast.ui.featured.ItemMarginDecoration;
import com.aspsine.podcast.util.DisplayUtil;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan10 on 16/9/18.
 */

public class TagListViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<TagListViewModel> {

    public RecyclerView recyclerView;
    private ItemViewAdapter<TagViewModel> mAdapter;

    public TagListViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView;
        recyclerView.setLayoutManager(new GridLayoutManager(itemView.getContext(), 1, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new ItemMarginDecoration(DisplayUtil.dip2px(itemView.getContext(), 12)));
        mAdapter = new ItemViewAdapter<>(new ArrayList<TagViewModel>(0));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBindViewHolder(int position, TagListViewModel tagListViewModel) {
        List<TagViewModel> tagViewModels = tagListViewModel.getTagViewModels();
        mAdapter.setList(tagViewModels);
    }
}
