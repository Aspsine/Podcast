package com.aspsine.podcast.ui.main;

import android.os.Bundle;
import android.view.View;

import com.aspsine.fragmentnavigator.FragmentNavigator;
import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.base.BaseActivity;
import com.aspsine.widget.OnBottomNavigationBarItemClickListener;

public class MainActivity extends BaseActivity implements OnBottomNavigationBarItemClickListener{

    private static final int DEFAULT_POSITION = 0;

    private FragmentNavigator mNavigator;

    private MainBottomNavigationBar mNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigator = new FragmentNavigator(getSupportFragmentManager(), new MainFragmentAdapter(), R.id.container);
        mNavigator.setDefaultPosition(DEFAULT_POSITION);
        mNavigator.onCreate(savedInstanceState);

        mNavigationBar = (MainBottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mNavigationBar.setOnBottomNavigationBarItemClickListener(this);

        setCurrentTab(mNavigator.getCurrentPosition());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigator.onSaveInstanceState(outState);
    }

    @Override
    public void onBottomNavigationLayoutItemClick(int position, View view) {
        setCurrentTab(position);
    }

    private void setCurrentTab(int position) {
        mNavigator.showFragment(position);
        mNavigationBar.selectTab(position);
    }
}
