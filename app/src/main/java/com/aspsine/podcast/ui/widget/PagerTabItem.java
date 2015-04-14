package com.aspsine.podcast.ui.widget;

import android.support.v4.view.ViewPager;

import com.aspsine.podcast.ui.fragment.BaseTabFragment;
import com.google.widget.SlidingTabLayout;
/**
 * Created by Aspsine on 2015/4/14.
 */
public class PagerTabItem {
    /**
     * This class represents a tab to be displayed by {@link ViewPager} and it's associated
     * {@link SlidingTabLayout}.
     */
    private final CharSequence mTitle;
    private final int mIndicatorColor;
    private final int mDividerColor;

    public PagerTabItem(CharSequence title, int indicatorColor, int dividerColor) {
        mTitle = title;
        mIndicatorColor = indicatorColor;
        mDividerColor = dividerColor;
    }

    /**
     * @return A new {@link android.support.v4.app.Fragment} to be displayed by a {@link ViewPager}
     */
    public android.support.v4.app.Fragment createFragment(int position) {
        return BaseTabFragment.newInstance(position);
    }

    /**
     * @return the title which represents this tab. In this sample this is used directly by
     * {@link android.support.v4.view.PagerAdapter#getPageTitle(int)}
     */
    public CharSequence getTitle() {
        return mTitle;
    }

    /**
     * @return the color to be used for indicator on the {@link SlidingTabLayout}
     */
    public int getIndicatorColor() {
        return mIndicatorColor;
    }

    /**
     * @return the color to be used for right divider on the {@link SlidingTabLayout}
     */
    public int getDividerColor() {
        return mDividerColor;
    }
}
