package com.aspsine.podcast.ui.main.featured.item.title;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;

/**
 * Created by aspsine on 16/9/18.
 */

public class TitleViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<TitleViewModel> {

    private TextView textView;

    public TitleViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }

    @Override
    public void onBindViewHolder(int position, TitleViewModel viewModel) {
        textView.setText(viewModel.getText());
    }
}
