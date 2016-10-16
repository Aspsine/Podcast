package com.aspsine.podcast.ui.main;

import android.support.v4.app.Fragment;

import com.aspsine.fragmentnavigator.FragmentNavigatorAdapter;
import com.aspsine.podcast.ui.main.discover.DiscoverFragment;
import com.aspsine.podcast.ui.main.featured.FeaturedFragment;
import com.aspsine.podcast.ui.main.me.MeFragment;
import com.aspsine.podcast.ui.main.podcasts.MyPodcastsFragment;

/**
 * Created by aspsine on 16/9/11.
 */

class MainFragmentAdapter implements FragmentNavigatorAdapter {

    @Override
    public Fragment onCreateFragment(int position) {
        switch (position){
            case 0:
                return MyPodcastsFragment.newInstance();
            case 1:
                return FeaturedFragment.newInstance();
            case 2:
                return DiscoverFragment.newInstance();
            case 3:
                return MeFragment.newInstance();
            default:
                throw new IllegalArgumentException("Wrong position!");
        }
    }

    @Override
    public String getTag(int position) {
        switch (position){
            case 0:
                return MyPodcastsFragment.class.getName();
            case 1:
                return FeaturedFragment.class.getName();
            case 2:
                return DiscoverFragment.class.getName();
            case 3:
                return MeFragment.class.getName();
            default:
                throw new IllegalArgumentException("Wrong position!");
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
