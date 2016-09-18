package com.aspsine.podcast.ui.featured.viewmodel.type;

import com.aspsine.podcast.ui.featured.viewmodel.FeaturedItem;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by aspsine on 16/9/17.
 */

public class FeaturedBanner implements ItemViewModel{

    private List<FeaturedItem> featuredItems;

    public List<FeaturedItem> getFeaturedItems() {
        return featuredItems;
    }

    public void setFeaturedItems(List<FeaturedItem> featuredItems) {
        this.featuredItems = featuredItems;
    }
}
