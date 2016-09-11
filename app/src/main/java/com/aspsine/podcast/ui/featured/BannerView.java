package com.aspsine.podcast.ui.featured;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.aspsine.podcast.widget.banner.BannerContract;


/**
 * Created by aspsine on 16/9/11.
 */

public class BannerView extends LinearLayout implements BannerContract.View{

    public BannerView(Context context) {
        super(context);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setPresenter(BannerContract.Presenter presenter) {

    }
}
