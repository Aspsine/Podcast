package com.aspsine.podcast.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.aspsine.podcast.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Aspsine on 2015/6/23.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    @InjectView(R.id.action_bar)
    Toolbar toolbar;

    protected abstract int getContentView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.inject(this);
        initActionbar();
    }

    private void initActionbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
    }

    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
