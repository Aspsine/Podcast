package com.aspsine.podcast.ui.main;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.widget.OnBottomNavigationBarItemClickListener;

/**
 * Created by aspsine on 16/9/11.
 */

public class MainBottomNavigationBar extends LinearLayoutCompat {

    private static final int TEXTS[] = {
            R.string.main_tab_my_podcast,
            R.string.main_tab_featured,
            R.string.main_tab_discover,
            R.string.main_tab_me
    };

    private static final int DRAWABLE[] = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    private OnBottomNavigationBarItemClickListener mOnItemClickListener;

    public MainBottomNavigationBar(Context context) {
        this(context, null);
    }

    public MainBottomNavigationBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainBottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        LayoutInflater inflater = LayoutInflater.from(context);
        for (int i = 0; i < TEXTS.length; i++) {
            View view = inflater.inflate(R.layout.layout_main_bottom_navigation_bar_item, this, false);
            TabViewHolder holder = new TabViewHolder(view);
            holder.textView.setText(getResources().getString(TEXTS[i]));
            holder.imageView.setBackground(getResources().getDrawable(DRAWABLE[i]));
            final int finalI = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onBottomNavigationLayoutItemClick(finalI, v);
                    }
                }
            });
            addView(view);
        }
    }

    public void setOnBottomNavigationBarItemClickListener(OnBottomNavigationBarItemClickListener onBottomNavigationBarItemClickListener) {
        this.mOnItemClickListener = onBottomNavigationBarItemClickListener;
    }

    public void selectTab(int position) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (i == position) {
                selectChild(child, true);
            } else {
                selectChild(child, false);
            }
        }
    }

    private void selectChild(View child, boolean select) {
        if (child instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) child;
            group.setSelected(select);
            for (int i = 0; i < group.getChildCount(); i++) {
                selectChild(group.getChildAt(i), select);
            }
        } else {
            child.setSelected(select);
            if (child instanceof ImageView) {
                ImageView iv = (ImageView) child;
                Drawable drawable = iv.getBackground().mutate();
                if (select) {
                    drawable.setColorFilter(getResources().getColor(R.color.text_color_primary), PorterDuff.Mode.SRC_ATOP);
                } else {
                    drawable.setColorFilter(getResources().getColor(R.color.text_color_secondary), PorterDuff.Mode.SRC_ATOP);
                }
            }
        }
    }

    static class TabViewHolder {
        ImageView imageView;
        TextView textView;

        public TabViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.iv_cover);
            textView = (TextView) view.findViewById(R.id.text_view);
        }
    }
}
