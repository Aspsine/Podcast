package com.aspsine.podcast.widget.recyclerView.loadmore;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aspsine.podcast.R;

/**
 * Created by aspsine on 16/10/22.
 */

public class LoadMoreItemView extends FrameLayout {

    private TextView textView;
    private ProgressBar progressBar;

    private State mState;

    public LoadMoreItemView(Context context) {
        super(context);
        inflate(context, R.layout.layout_load_more, this);
        textView = (TextView) findViewById(R.id.text_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        setState(State.Empty);
    }

    public void setState(State state) {
        if (state == null){
            state = State.Empty;
        }
        mState = state;
        switch (state) {
            case Empty:
                textView.setVisibility(GONE);
                progressBar.setVisibility(GONE);
                break;
            case LoadingMore:
                progressBar.setVisibility(VISIBLE);
                textView.setVisibility(GONE);
                break;
            case End:
                progressBar.setVisibility(GONE);
                textView.setVisibility(VISIBLE);
                textView.setText("The End");
                break;
            case Error:
                progressBar.setVisibility(GONE);
                textView.setVisibility(VISIBLE);
                textView.setText("Error");
                break;
        }
    }

    public State getState(){
        return mState;
    }
}
