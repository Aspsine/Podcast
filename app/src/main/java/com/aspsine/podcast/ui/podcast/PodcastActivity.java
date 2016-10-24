package com.aspsine.podcast.ui.podcast;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.base.BaseActivity;

public class PodcastActivity extends BaseActivity {

    private static final String EXTRA_PODCAST_ID = "extra_podcast_id";

    public static void intentInto(Context context, String podcastId){
        Intent intent = new Intent(context, PodcastActivity.class);
        intent.putExtra(EXTRA_PODCAST_ID, podcastId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast);
        Intent intent = getIntent();
        if (savedInstanceState == null) {

            String podcastId = intent.getStringExtra(EXTRA_PODCAST_ID);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, PodcastFragment.newInstance(podcastId), PodcastFragment.TAG)
                    .commit();
        }
    }
}
