package com.aspsine.podcast.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.podcast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseTabFragment extends Fragment {

    private static final String KEY_TITLE = "title";

    /**
     * @return a new instance of {@link BaseTabFragment}, adding the parameters into a bundle and
     * setting them as arguments.
     */
    public static BaseTabFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
                return new PodcastsFragment();
            case 1:
                return new SubscriptionsFragment();
            case 2:
                return new StationsFragment();
            case 3:
                return new FeaturedFragment();
        }
        return null;
    }

    public BaseTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
            TextView title = (TextView) view.findViewById(R.id.item_title);
            title.setText("Title: " + args.getCharSequence(KEY_TITLE));
        }
    }


}
