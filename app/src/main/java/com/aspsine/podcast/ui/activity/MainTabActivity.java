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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
