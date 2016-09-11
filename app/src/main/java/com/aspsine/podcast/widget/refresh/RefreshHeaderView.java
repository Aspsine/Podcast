package com.aspsine.podcast.widget.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aspsine.irecyclerview.RefreshTrigger;

/**
 * Created by aspsine on 16/9/11.
 */

public class RefreshHeaderView extends TextView implements RefreshTrigger {

    private int mHeight;

    public RefreshHeaderView(Context context) {
        this(context, null);
    }

    public RefreshHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onStart(boolean automatic, int headerHeight, int finalHeight) {
        mHeight = headerHeight;
    }

    @Override
    public void onMove(boolean isComplete, boolean automatic, int moved) {
        if (!isComplete) {
            if (moved < mHeight){
                setText("SWIPE TO REFRESH");
            } else {
                setText("RELEASE TO REFRESH");
            }
        }
    }

    @Override
    public void onRefresh() {
        setText("REFRESHING");
    }

    @Override
    public void onRelease() {

    }

    @Override
    public void onComplete() {
        setText("COMPLETE");
    }

    @Override
    public void onReset() {

    }
}
