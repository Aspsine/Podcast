package com.aspsine.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by aspsine on 16/9/10.
 */
public class BottomNavigationItemView extends LinearLayout implements Checkable {

    private boolean mChecked;

    public ImageView imageView;

    public TextView textView;

    private int mMode;

    private int mColorType;

    private int mLayoutType;

    private static final int[] CHECKED_STATE_SET = {
            android.R.attr.state_checked,
    };


    public BottomNavigationItemView(Context context) {
        super(context);
    }

    public BottomNavigationItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomNavigationItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(VERTICAL);

        imageView = new ImageView(context);
        imageView.setLayoutParams(generateDefaultLayoutParams());
        textView = new TextView(context);
        textView.setLayoutParams(generateDefaultLayoutParams());
        addView(imageView);
        addView(textView);
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            imageView.setSelected(mChecked);
            textView.setSelected(mChecked);
        }
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked());
    }

    public void apply(int mode, int colorType, int layoutType) {
        this.mMode = mode;
        this.mColorType = colorType;
        this.mLayoutType = layoutType;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        switch (mMode){
            case BottomNavigationBar.MODE_FIXED:

                break;
            case BottomNavigationBar.MODE_SHIFTING:

                break;
            default:
                throw new IllegalArgumentException("Wrong mode!");
        }

        switch (mLayoutType){
            case BottomNavigationBar.LAYOUT_SPEC:

                break;
            case BottomNavigationBar.LAYOUT_FREE:

                break;
            default:
                throw new IllegalArgumentException("Wrong layout type!");
        }
    }
}
