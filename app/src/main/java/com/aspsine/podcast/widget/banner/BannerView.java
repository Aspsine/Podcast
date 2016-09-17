package com.aspsine.podcast.widget.banner;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.aspsine.podcast.R;


/**
 * Created by aspsine on 16/9/11.
 */

public class BannerView extends FrameLayout {

    private int mItemCount;

    private int mItemLayoutId;

    private ViewPager viewPager;

    private Adapter mAdapter;

    private LinearLayout indicatorLayout;

    private OnDataBindingCallback mCallback;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }

    public interface OnDataBindingCallback {
        void onDataBinding(int position, View view);

        int getItemCount();
    }

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.layout_banner, this);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        indicatorLayout = (LinearLayout) findViewById(R.id.indicator_container);
    }

    public void setItemLayoutId(int itemLayoutId) {
        this.mItemLayoutId = itemLayoutId;
    }

    public void setOnDataBindingCallback(OnDataBindingCallback callback) {
        this.mCallback = callback;
        if (mAdapter == null) {
            mAdapter = new Adapter();
            viewPager.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    private class Adapter extends PagerAdapter {

        private LayoutInflater mInflater;

        public Adapter() {
            mInflater = LayoutInflater.from(getContext());
        }

        @Override
        public int getCount() {
            return mCallback == null ? 0 : mCallback.getItemCount();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            final View view = mInflater.inflate(mItemLayoutId, container, false);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(position, view);
                    }
                }
            });
            if (mCallback != null) {
                mCallback.onDataBinding(position, view);
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


}
