package com.aspsine.podcast.ui.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.fragment.MainTabsFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainTabActivity extends ActionBarActivity {
    @InjectView(R.id.action_bar)
    Toolbar actionBarToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);
        ButterKnife.inject(this);
        initActionbar();
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            MainTabsFragment fragment = new MainTabsFragment();
            transaction.replace(R.id.container, fragment);
            transaction.commit();
        }
    }

    private void initActionbar() {
        setSupportActionBar(actionBarToolbar);
        ActionBar actionBar = getSupportActionBar();
    }

}
