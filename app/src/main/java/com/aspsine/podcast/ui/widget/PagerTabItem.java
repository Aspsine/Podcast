package com.aspsine.podcast.ui.widget;

import android.support.v4.app.Fragment;
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
    private final Type mType;
    private final Fragment mFragment;

    public enum Type{
        CATEGORIES, SUBSCRIPTIONS, TRENDING;
    }

    public PagerTabItem(Type type, CharSequence title, int indicatorColor, int dividerColor) {
        mType = type;
        mTitle = title;
        mIndicatorColor = indicatorColor;
        mDividerColor = dividerColor;

        mFragment = createFragment();
    }

    /**
     * @return A new {@link android.support.v4.app.Fragment} to be displayed by a {@link ViewPager}
     */
    private android.support.v4.app.Fragment createFragment() {
        return BaseTabFragment.newInstance(mType);
    }

    public Fragment getFragment(){
        return mFragment;
    }

    public Type getType(){
        return mType;
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
