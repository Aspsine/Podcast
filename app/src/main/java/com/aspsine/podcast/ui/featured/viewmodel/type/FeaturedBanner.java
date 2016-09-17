package com.aspsine.podcast.ui.featured.viewmodel.type;

import com.aspsine.podcast.ui.featured.viewmodel.FeaturedItem;

import java.util.List;

/**
 * Created by aspsine on 16/9/17.
 */

public class FeaturedBanner {

    private List<FeaturedItem> featuredItems;

    public List<FeaturedItem> getFeaturedItems() {
        return featuredItems;
    }

    public void setFeaturedItems(List<FeaturedItem> featuredItems) {
        this.featuredItems = featuredItems;
    }
}
