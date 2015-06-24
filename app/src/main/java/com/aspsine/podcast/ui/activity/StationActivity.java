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
        Intent intent = getIntent();
        Station station = (Station) intent.getSerializableExtra("EXTRA_STATION");
        Fresco.initialize(this);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, StationFragment.newInstance(station)).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_station, menu);
        return true;
    }


}
