package com.aspsine.podcast.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.base.BaseActivity;
import com.aspsine.podcast.ui.main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intentIntoMain();
            }
        }, 2000);
    }

    private void intentIntoMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
