package com.aspsine.podcast.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.aspsine.podcast.R;


/**
 * Created by aspsine on 16/1/29.
 */
public class RatioImageView extends ImageView {

    private int mRatioBy;

    private float mRatio;

    public static final int RATIO_BY_WIDTH = 0;
    public static final int RATIO_BY_HEIGHT = 1;

    @IntDef(value = {RATIO_BY_WIDTH, RATIO_BY_HEIGHT})
    @interface RatioBy {
    }

    public RatioImageView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView, defStyleAttr, 0);
        try {
            mRatioBy = a.getInt(R.styleable.RatioImageView_ratioBy, RATIO_BY_WIDTH);
            mRatio = a.getFloat(R.styleable.RatioImageView_ratio, 0);
        } finally {
            a.recycle();
        }
    }

    public void setRatioBy(@RatioBy int squaredBy) {
        this.mRatioBy = squaredBy;
        requestLayout();
    }

    public void setRatio(float ratio) {
        this.mRatio = ratio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mRatio > 0) {
            int width = getMeasuredWidth();
            int height = getMeasuredHeight();
            if (mRatioBy == RATIO_BY_WIDTH) {
                height = (int) (width * mRatio);
            } else if (mRatioBy == RATIO_BY_HEIGHT) {
                width = (int) (height * mRatio);
            }
            setMeasuredDimension(width, height);
        }
    }
}
