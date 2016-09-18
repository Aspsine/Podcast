package com.aspsine.podcast.ui.featured.item.tag;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;

/**
 * Created by zhangfan10 on 16/9/18.
 */

public class TagViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<TagViewModel>{

    TextView textView;

    public TagViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView;
    }

    @Override
    public void onBindViewHolder(int position, TagViewModel tagViewModel) {
        textView.setText(tagViewModel.getText());
    }
}
