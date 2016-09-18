package com.aspsine.podcast.ui.featured.item.banner;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/18.
 */

public class BannerViewModel implements ItemViewModel{

    private List<ItemViewModel> itemViewModels;

    public List<ItemViewModel> getItemViewModels() {
        return itemViewModels;
    }

    public void setItemViewModels(List<ItemViewModel> itemViewModels) {
        this.itemViewModels = itemViewModels;
    }
}
