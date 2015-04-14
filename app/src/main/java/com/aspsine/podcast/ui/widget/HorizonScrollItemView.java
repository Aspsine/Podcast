package com.aspsine.podcast.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aspsine.podcast.R;

/**
 * Created by aspsine on 15-4-14.
 */
public class HorizonScrollItemView extends LinearLayout {

    public HorizonScrollItemView(Context context) {
        this(context, null);
    }

    public HorizonScrollItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizonScrollItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(lp);
        setOrientation(VERTICAL);
        LayoutInflater.from(getContext()).inflate(R.layout.item_horizon_scroll, this, true);
    }

}
