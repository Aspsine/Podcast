package com.aspsine.podcast.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.PodCast;
import com.aspsine.podcast.ui.fragment.PodCastFragment;

public class PodCastActivity extends BaseAppCompatActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_pod_cast;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        PodCast podCast = (PodCast) intent.getSerializableExtra("EXTRA_PODCAST");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, PodCastFragment.newInstance(podCast)).commit();
        }
    }

}
