package com.aspsine.podcast.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.fragment.MainTabsFragment;

public class MainTabActivity extends BaseAppCompatActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_main_tab;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            MainTabsFragment fragment = new MainTabsFragment();
            transaction.replace(R.id.container, fragment);
            transaction.commit();
        }
    }


}
