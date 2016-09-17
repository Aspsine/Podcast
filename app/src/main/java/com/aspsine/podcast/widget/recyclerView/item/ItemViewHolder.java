package com.aspsine.podcast.widget.recyclerView.item;

/**
 * Created by aspsine on 16/9/17.
 */

public interface ItemViewHolder<ViewModel extends ItemViewModel>{

    void onBindViewHolder(int position, ViewModel viewModel);

}
