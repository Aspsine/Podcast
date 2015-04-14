package com.aspsine.podcast.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aspsine.podcast.ui.widget.PagerTabItem;
import com.google.widget.SlidingTabLayout;

import java.util.List;

/**
 * Created by Aspsine on 2015/4/14.
 */
public class TabStatePagerAdapter extends FragmentStatePagerAdapter {
    private List<PagerTabItem> mTabs;
    public TabStatePagerAdapter(List<PagerTabItem> tabs, FragmentManager fm){
        super(fm);
        mTabs = tabs;
    }

    TabStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mTabs.get(i).createFragment(i);
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    /**
     * Return the title of the item at {@code position}. This is important as what this method
     * returns is what is displayed in the {@link SlidingTabLayout}.
     * <p/>
     * Here we return the value returned from {@link PagerTabItem#getTitle()}.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs.get(position).getTitle();
    }
}
