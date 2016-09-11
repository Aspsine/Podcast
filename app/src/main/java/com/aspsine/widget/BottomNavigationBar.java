package com.aspsine.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by aspsine on 16/9/10.
 */

public class BottomNavigationBar extends LinearLayout {

    @Mode
    private int mMode;

    @ColorType
    private int mColorType;

    @LayoutType
    private int mLayoutType;

    private int mPosition;

    private OnBottomNavigationBarItemClickListener mListener;

    public BottomNavigationBar(Context context) {
        this(context, null);
    }

    public BottomNavigationBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(HORIZONTAL);

        init();
    }

    public void setMode(@Mode int mode){
        this.mMode = mode;
    }

    public void setColorType(@ColorType int colorType){
        this.mColorType = colorType;
    }

    public void setLayoutType(@LayoutType int layoutType){
        this.mLayoutType = layoutType;
    }

    private void init(){
        for (int i = 0; i < getChildCount(); i++) {
            final View view = getChildAt(i);
            final int finalI = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onBottomNavigationLayoutItemClick(finalI, view);
                    }
                }
            });
        }
    }

    public void setAdapter(Adapter adapter){
        removeAllViews();
        int count = adapter.getItemCount();
        for (int i = 0 ; i < count; i++){
            addTab(adapter.getDrawable(i), adapter.getText(i));
        }
        select(mPosition);
    }

    private void addTab(Drawable drawable, CharSequence text){
        BottomNavigationItemView itemView = new BottomNavigationItemView(getContext());
        itemView.apply(mMode, mColorType, mLayoutType);
        itemView.imageView.setBackgroundDrawable(drawable);
        itemView.textView.setText(text);
        itemView.setLayoutParams(generateDefaultLayoutParams());
        addView(itemView);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    public void select(int position) {
        for (int i = 0; i < getChildCount(); i++) {
            Checkable checkable = (Checkable) getChildAt(position);
            if (position == i) {
                if (!checkable.isChecked()) {
                    checkable.setChecked(true);
                }
            } else {
                if (checkable.isChecked()) {
                    checkable.setChecked(false);
                }
            }
        }
    }

    public static final int MODE_FIXED = 0;
    public static final int MODE_SHIFTING = 1;

    @IntDef(value = {MODE_FIXED, MODE_SHIFTING})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static final int COLOR_CONTENT = 0;
    public static final int COLOR_BG = 1;

    @IntDef(value = {COLOR_CONTENT, COLOR_BG})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorType {
    }

    public static final int LAYOUT_SPEC = 0;
    public static final int LAYOUT_FREE = 1;

    @IntDef(value = {LAYOUT_SPEC, LAYOUT_FREE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutType {
    }

    interface Adapter{

        int getItemCount();

        Drawable getDrawable(int position);

        CharSequence getText(int position);
    }

}
