package com.aspsine.podcast.ui.search.item;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.podcast.PodcastActivity;
import com.aspsine.podcast.util.BBCImageUtils;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.bumptech.glide.Glide;

/**
 * Created by aspsine on 16/10/30.
 */

public class SearchPodcastViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<SearchPodcastViewModel> {

    private ImageView ivCover;

    private TextView tvName;

    private TextView tvDescription;

    public SearchPodcastViewHolder(View itemView) {
        super(itemView);
        ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
    }

    @Override
    public void onBindViewHolder(int position, final SearchPodcastViewModel viewModel) {
        tvName.setText(viewModel.getName());
        tvDescription.setText(Html.fromHtml(viewModel.getDescription()));
        Glide.with(ivCover.getContext()).load(BBCImageUtils.getImageUrl(viewModel.getArtwork(), ivCover.getLayoutParams().width)).centerCrop().into(ivCover);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PodcastActivity.intentInto(v.getContext(), viewModel.getId());
            }
        });
    }
}
