package com.aspsine.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.Station;
import com.aspsine.podcast.ui.fragment.StationFragment;
import com.facebook.drawee.backends.pipeline.Fresco;

public class StationActivity extends BaseAppCompatActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_station;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        Intent intent = getIntent();
        Station station = (Station) intent.getSerializableExtra("EXTRA_STATION");
        setTitle(station.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, StationFragment.newInstance(station)).commit();
        }
    }
}
