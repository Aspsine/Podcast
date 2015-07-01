package com.aspsine.podcast.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.podcast.R;
import com.aspsine.podcast.ui.widget.PagerTabItem;
import com.aspsine.podcast.ui.widget.PagerTabItem.Type;

import static com.aspsine.podcast.ui.widget.PagerTabItem.Type.*;
import static com.aspsine.podcast.ui.widget.PagerTabItem.Type.CATEGORIES;
import static com.aspsine.podcast.ui.widget.PagerTabItem.Type.SUBSCRIPTIONS;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseTabFragment extends BaseFragment {

    private static final String KEY_TITLE = "title";

    /**
     * @return a new instance of {@link BaseTabFragment}, adding the parameters into a bundle and
     * setting them as arguments.
     */
    public static BaseTabFragment newInstance(Type type) {
        Bundle bundle = new Bundle();
        switch (type) {
            case CATEGORIES:
                return new CategoriesFragment();
            case SUBSCRIPTIONS:
                return new SubscriptionsFragment();
            case TRENDING:
                return new TrendingFragment();
        }
        return null;
    }

    public BaseTabFragment() {
        // Required empty public constructor
    }

    public abstract Type getType();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
//            TextView title = (TextView) view.findViewById(R.id.item_title);
//            title.setText("Title: " + args.getCharSequence(KEY_TITLE));
        }
    }



}
