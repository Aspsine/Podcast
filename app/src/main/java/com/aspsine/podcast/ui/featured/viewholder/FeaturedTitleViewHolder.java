package com.aspsine.podcast.ui.featured.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aspsine.podcast.ui.featured.viewmodel.FeaturedTitle;

/**
 * Created by aspsine on 16/9/13.
 */

public class FeaturedTitleViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public FeaturedTitleViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView;
    }

    public void bind(FeaturedTitle featuredTitle){
        textView.setText(featuredTitle.getText());
    }

}
