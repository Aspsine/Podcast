package com.aspsine.podcast.ui.podcast.item;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.podcast.R;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewHolder;
import com.bumptech.glide.Glide;

import java.util.Calendar;

/**
 * Created by aspsine on 16/10/15.
 */

public class EpisodeViewHolder extends RecyclerView.ViewHolder implements ItemViewHolder<EpisodeViewModel>{

    private TextView tvName;

    private TextView tvUpdateTime;

    private TextView tvDescription;

    public EpisodeViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView)itemView.findViewById(R.id.tv_name);
        tvUpdateTime = (TextView)itemView.findViewById(R.id.tv_update_time);
        tvDescription = (TextView)itemView.findViewById(R.id.tv_description);
    }

    @Override
    public void onBindViewHolder(int position, final EpisodeViewModel viewModel) {
        tvName.setText(viewModel.getTitle());
        tvUpdateTime.setText(viewModel.getPubDate().replace("+0000",""));
        tvDescription.setText(viewModel.getDescription());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), viewModel.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
