package com.aspsine.podcast.ui.featured.viewmodel;

import android.support.annotation.IntDef;

/**
 * Created by aspsine on 16/9/13.
 */

public class FeaturedItem {

    public static final int TYPE_FEATURED_TITLE = 1;

    public static final int TYPE_HOT_TAGS = 2;

    public static final int TYPE_FEATURED_PROVIDER = 11;

    public static final int TYPE_FEATURED_STATION = 12;

    public static final int TYPE_FEATURED_PODCAST = 13;

    public static final int TYPE_FEATURED_EPISODE = 14;

    public static final int TYPE_FEATURED_PROVIDER_LIST = 21;

    public static final int TYPE_FEATURED_STATION_LIST = 22;

    public static final int TYPE_FEATURED_PODCAST_LIST = 23;

    public static final int TYPE_FEATURED_EPISODE_LIST = 24;

    @IntDef(value = {
            TYPE_FEATURED_TITLE,
            TYPE_HOT_TAGS,
            TYPE_FEATURED_PROVIDER,
            TYPE_FEATURED_STATION,
            TYPE_FEATURED_PODCAST,
            TYPE_FEATURED_EPISODE,
            TYPE_FEATURED_PROVIDER_LIST,
            TYPE_FEATURED_STATION_LIST,
            TYPE_FEATURED_PODCAST_LIST,
            TYPE_FEATURED_EPISODE_LIST,
    })
    @interface Type {
    }

    @Type
    private int type;

    @Type
    private int childType;

    private FeaturedProvider featuredProvider;

    private FeaturedStation featuredStation;

    private FeaturedPodcast featuredPodcast;

    private FeaturedTitle featuredTitle;


}
